package jdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc1.DBConnection;

//** DAO(Data Access Object)
//=> SQL 구문 처리
//=> CRUD 구현 
// Create(insert), Read(select), Update, Delete

public class StudentDAO {

	// ** 전역변수 정의
	private static Connection cn = DBConnection.getConnection(); // dbconnection 갖고오기.
	private static Statement st; // sql문 처리.
	private static PreparedStatement pst; // sql문 처리. 처리효율이 더 높음.
	private static ResultSet rs; // 쿼리 결과문 처리.
	private static String sql;

	// 1. selectList
	// => 처리 결과를 담아 전달할 List 필요.
	public List<StudentVO> selectList() { // 리턴타입 List, StudentVO 타입으로 설정.
		sql = "select * from student";

		// ** List 정의.
		// => 일괄 순차처리에 가장 적합한 Collection : ArrayList 사용.
		List<StudentVO> list = new ArrayList<StudentVO>();
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			// 3) 결과처리
			// => select 문의 결과가 있는지 확인.
			if (rs.next()) {
				// select문 결과 있음 => List에 담아 전달(Service -> Controller)
				do { // List 에 데이터 값 저장.

					StudentVO vo = new StudentVO(); // 주소를 가짐.
					vo.setId(rs.getString(1));
					vo.setName(rs.getString("name"));
					vo.setAge(rs.getInt(3));
					vo.setJno(rs.getInt(4));
					vo.setInfo(rs.getString(5));
					vo.setPoint(rs.getDouble(6));
					vo.setBirthday(rs.getString(7));
					list.add(vo);

				} while (rs.next());
			} else {
				// select문 결과 없음
				System.out.println("** selectList : 출력자료가 1건도 없음 **");
				list = null;
			}
		} catch (Exception e) {
			System.out.println("** selectList Exception => " + e.toString());
			list = null;

		}
		return list;
	}// selectList

//	2. selectOne : Detail
//	=> id를 이용해서 selectOne 한 결과  return
	public StudentVO selectOne(StudentVO vo) {
		sql = "select * from student where id=?";

		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			rs = pst.executeQuery();
			if (rs.next()) {
				// select 성공
				vo.setId(rs.getString(1));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt(3));
				vo.setJno(rs.getInt(4));
				vo.setInfo(rs.getString(5));
				vo.setPoint(rs.getDouble(6));
				vo.setBirthday(rs.getString(7));
			} else {
				// select 실패
				vo = null;
			}
		} catch (Exception e) {
			System.out.println("** selectOne Exception => " + e.toString());
			vo = null;
		}
		return vo;
	}// selectOne

	// 3. insert
	public int insert(StudentVO vo) {
		sql = "insert into student values(?,?,?,?,?,?,?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getName());
			pst.setInt(3, vo.getAge());
			pst.setInt(4, vo.getJno());
			pst.setString(5, vo.getInfo());
			pst.setDouble(6, vo.getPoint());
			pst.setString(7, vo.getBirthday());

			return pst.executeUpdate(); // 성공 시 1 리턴. 메서드 리턴 타입이 int형이므로.

		} catch (Exception e) {
			System.out.println("** selectOne Exception => " + e.toString());
			return 0; // 입력이나 수정에서 오류 난 경우 0
		}

	}// insert

	// 4. update
	public int update(StudentVO vo) {
		sql = "update student set name=?, point=?, birthday2=? where id=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getName());
			pst.setDouble(2, vo.getPoint());
			pst.setString(3, vo.getBirthday());
			pst.setString(4, vo.getId());
			return pst.executeUpdate(); // 성공 시 1 리턴. 메서드 리턴 타입이 int형이므로.
		} catch (Exception e) {
			System.out.println("** update Exception => " + e.toString());
			return 0; // 입력이나 수정에서 오류 난 경우 0
		}
	}// update

	// 5. delete
	public int delete(StudentVO vo) {
		sql = "delete from student where id=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			return pst.executeUpdate(); // 성공 시 1 리턴. 메서드 리턴 타입이 int형이므로.
		} catch (Exception e) {
			System.out.println("** delete Exception => " + e.toString());
			return 0; // 입력이나 수정에서 오류 난 경우 0
		}
	}// delete

} // class
