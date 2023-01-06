package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.GroupDTO;
import vo.StudentrVO;


//** DAO(Data Access Object)
//=> SQL 구문 처리
//=> CRUD 구현 
//   Create(insert), Read(select), Update, Detete
// 3번째

public class StudentrDAO {
	
	// ** 전역변수 정의
	private static Connection cn=DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	
	// 1. selectList
	// => 처리 결과를 담아 전달할 List 가 필요함
	public List<StudentrVO> selectList() {
		sql="select * from studentr";
		// ** List 정의
		// => 일괄적 순차처리에 가장 적합한 Collection ArrayList 사용
		List<StudentrVO> list = new ArrayList<StudentrVO>();
		try {
			st=cn.createStatement();
			rs=st.executeQuery(sql);
			// 3) 결과처리	
			// => select 문의 결과가 있는지 확인
			if (rs.next()) {
				// select문 결과 있음 => List 에 담아 전달 (Service -> Controller) 
				do {
					StudentrVO vo = new StudentrVO();
					vo.setId(rs.getString(1));
					vo.setName(rs.getString(2));
					vo.setAge(rs.getInt(3));
					vo.setJno(rs.getInt(4));
					vo.setInfo(rs.getString(5));
					vo.setPoint(rs.getDouble(6));
					vo.setBirthday(rs.getString(7));
					list.add(vo);
				}while(rs.next());
			}else {
				// select문 결과 없음
				System.out.println("** selectList : 출력자료가 1건도 없음 **");
				list = null;
			}
		} catch (Exception e) {
			System.out.println("** selectList Exception => "+e.toString());
			list = null;
		}
		return list;
	} //selectList
	
	
	// 2. selectOnew : Detail
	// => id를 이용해서 selectOne 한 결과를 return
	public StudentrVO selectOne (StudentrVO vo) {
		sql = "select * from studentr where id=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			rs=pst.executeQuery();
			
			if(rs.next()) {
				//select 성공
				vo.setId(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setAge(rs.getInt(3));
				vo.setJno(rs.getInt(4));
				vo.setInfo(rs.getString(5));
				vo.setPoint(rs.getDouble(6));
				vo.setBirthday(rs.getString(7));
			} else {
				//select 실패
				vo = null;
			}
		} catch(Exception e) {
			System.out.println("** selectOne Exception => "+e.toString());
			vo =null;
		}
		return vo;
	} // selectOne
	
	// 3. insert
	public int insert(StudentrVO vo) {
		sql = "insert into studentr values(?,?,?,?,?,?,?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getName());
			pst.setInt(3, vo.getAge());
			pst.setInt(4, vo.getJno());
			pst.setString(5, vo.getInfo());
			pst.setDouble(6, vo.getPoint());
			pst.setString(7, vo.getBirthday());
			
			return pst.executeUpdate();	
		} catch (Exception e) {
			System.out.println("** insert Exception => "+e.toString());
			return 0;
		}
	}
	
	// 4. update
	public int update(StudentrVO vo) {
		sql = "update studentr set name=? where id=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getName());
			pst.setString(2, vo.getId());
			
			return pst.executeUpdate();	
		} catch (Exception e) {
			System.out.println("** insert Exception => "+e.toString());
			return 0;
		}
	}//update
	
	// 5. delete
	public int delete(StudentrVO vo) {
		sql = "delete from studentr where id=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			
			return pst.executeUpdate();	
		} catch (Exception e) {
			System.out.println("** delete Exception => "+e.toString());
			return 0;
		}
	}//delete
	
	// 6. group
	public List<GroupDTO> groupTest() {
		sql= "select j.jno, j.jname, count(*) count, sum(age) sum, avg(age) avg, min(age) min, max(age) max\r\n"
				+ "from jor j, studentr s where j.jno = s.jno group by jno";
		List<GroupDTO> list = new ArrayList<GroupDTO>();
		try {
			pst=cn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()) {
				do {
					GroupDTO dto = new GroupDTO();
					dto.setJno(rs.getInt(1));
					dto.setJname(rs.getString(2));
					dto.setCount(rs.getInt(3));
					dto.setSum(rs.getInt(4));
					dto.setAvg(rs.getDouble(5));
					dto.setMin(rs.getInt(6));
					dto.setMax(rs.getInt(7));
					list.add(dto);
					
				}while(rs.next());
			}else {
				System.out.println("** groupTest : 출력자료 없음 **");
				list = null;
			}
		} catch (Exception e) {
			System.out.println("** GroupDTO Exception => "+e.toString());
			list = null;
		}
		return list;
	}//group
	
	// 트랜잭션 테스트
	  // => Connection 객체가 관리
	  // => 기본값은 AutoCommit true 임.
	  // => setAutoCommit(false) -> commit 또는 rollback
	  // 1) Test1
	  // => Transaction 적용하지 않고 오류 유발
	  // => 동일 자료 2회 입력 : 첫번째는 입력되고 , 두번째 입력에서 Exception 발생
	  // => Data 의 무결성에 영향을 주게됨
	  // 2) Test2
	  // => Transaction 적용하고 오류 유발
	  // => 동일 자료 2회 입력 : 첫번째 입력후, 두번째 입력에서 Exception 발생하지만 모두 rollback 됨.
	  // 즉, 모두 입력되지 않음

	public void transationTest() {
	      sql="insert into studentr values('xxx3','엑스맨3',77,'Transaction Test',5, 777.77,'tttt')";
	      // 1) Test1
	      // => Transaction 적용하지 않고 동일자료 2회 입력
//	      try {
//	         pst=cn.prepareStatement(sql);
//	         pst.executeUpdate(); // OK
//	         pst.executeUpdate(); // Key 중복 오류 -> chtch 블럭으로 이동
//	         
//	      } catch (Exception e) {
//	         System.out.println("** transactionTest1 Exception => "+e.toString());
//	      }
	      
	      // 2) Test2
	      // => Transaction 적용하고 동일자료 2회 입력 -> 모두 Rollback
	      try {
	         cn.setAutoCommit(false);
	         pst=cn.prepareStatement(sql);
	         pst.executeUpdate(); // OK
	         pst.executeUpdate(); // 키 중복오류 Exception -> catch 블럭으로
	         
	         //** 모든구문 정상실행 -> Rollback
	         cn.commit();
	      } catch (Exception e) {
	         System.out.println("** transactionTest1 Exception => "+e.toString());
	         try {
	            cn.rollback();
	         } catch (Exception e2) {
	            
	         }
	         
	      }
	      
	   }// transationTest

} //class
