package jdbc01;

import java.sql.*;

import jdbc02.StudentVO;

public class Ex01_Start {
	// ** 전역변수 정의
	private static Connection cn=DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	// ** Student List
	public static void selectList() {
		// 1) DBConnection
		// => 전역변수로 전달받음 
		
		// 2) SQL구문처리
		sql="select * from student";
		try {
			st=cn.createStatement();
			rs=st.executeQuery(sql);
			// 3) 결과처리	
			// => select 문의 결과가 있는지 확인
			if (rs.next()) {
				// select문 결과 있음
				// => 출력
				System.out.println("** Student List **");
				System.out.println("id  | name | age  | jno  | info      | point | birthday");
				do {
					System.out.print(rs.getString(1)+" "); // get컬럼타입(인덱스 또는 컬럼명)
					System.out.print(rs.getString("name")+" ");
					System.out.print(rs.getInt(3)+" ");
					System.out.print(rs.getInt(4)+" ");
					System.out.print(rs.getString(5)+" ");
					System.out.print(rs.getDouble(6)+" ");
					System.out.print(rs.getString(7)+"\n");
				}while(rs.next());
			}else {
				// select문 결과 없음
				System.out.println("** selectList : 출력자료가 1건도 없음 **");
			}
		} catch (Exception e) {
			System.out.println("** selectList Exception => "+e.toString());
		}
	} //selectList
	
	// ** 조건 검색 하기 : 조별 출력
	// 1. Statement
	public static void joListSt(int jno) {
		// 1) DBConnection
		// 2) SQL구문처리
		sql="select * from student where jno="+jno;
		try {
			st=cn.createStatement();
			rs=st.executeQuery(sql);
			// 3) 결과처리	
			// => select 문의 결과가 있는지 확인
			if (rs.next()) {
				// select문 결과 있음
				// => 출력
				System.out.println("** Student Jo_List **");
				System.out.println(" jno | id  | name | age  |  info      | point | birthday");
				do {
					System.out.print(rs.getInt(4)+" ");
					System.out.print(rs.getString(1)+" "); // get컬럼타입(인덱스 또는 컬럼명)
					System.out.print(rs.getString("name")+" ");
					System.out.print(rs.getInt(3)+" ");
					System.out.print(rs.getString(5)+" ");
					System.out.print(rs.getDouble(6)+" ");
					System.out.print(rs.getString(7)+"\n");
				}while(rs.next());
			}else {
				// select문 결과 없음
				System.out.println("** joListSt : 출력자료가 1건도 없음 **");
			}
		} catch (Exception e) {
			System.out.println("** joListSt Exception => "+e.toString());
		}
	} //joListSt
	
	// 2. PreparedStatement 
	// => ? 바인딩 변수를 이용
	public static void joListPst(int jno, String id) {
		sql="select * from student where jno=? and id>?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1, jno);
			pst.setString(2, id);
			rs=pst.executeQuery();
			if (rs.next()) {
				System.out.println("** Student Jo_List_Pst **");
				System.out.println(" jno | id  | name | age  |  info      | point | birthday");
				do {
					System.out.print(rs.getInt(4)+" ");
					System.out.print(rs.getString(1)+" ");  
					System.out.print(rs.getString("name")+" ");
					System.out.print(rs.getInt(3)+" ");
					System.out.print(rs.getString(5)+" ");
					System.out.print(rs.getDouble(6)+" ");
					System.out.print(rs.getString(7)+"\n");
				}while(rs.next());
			}else {
				System.out.println("** joListPst : 출력자료가 1건도 없음 **");
			}
		} catch (Exception e) {
			System.out.println("** joListPst Exception => "+e.toString());
		}
	} //joListPst
	
	// ** insert 메서드 만들기 (매개변수 활용)
	// => st or pst -> pst 가 효율적 
	// => 실행 메서드: executeUpdate()
	//	-> 처리한 Data의 갯수 return
	//	-> C insert , U update, D delete 의 경우 사용
	
	// => insert 구문 
	//    insert into student(id, name, age, info, jno) values('banana','김길동', 22, 'Test Data', 6); 
	// => Statement 객체 이용 
	//	 "insert into student(id, name, age, info, jno) values('"+id+"','"+name+"', "+age+", '"+info+"', "+jno+")";
	// => 위의 문자열 더하기의 불편함을 개선 한것이 PreparedStatement 이다.
	//    PreparedStatement 에서는 바인딩변수 ? 를 이용함
	//    insert into student(id, name, age, info, jno) values(?, ?, ?, ?, ?); 
	
	// => Before VO 정의
	//public void insert(String id, String name, int age, int jno, String info, double point, String birthday) {
	public void insert(StudentVO vo) {	
		sql="insert into student(id,name,age,jno,info,point,birthday) values(?,?,?,?,?,?,?)";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, vo.getId());   // id -> vo.getId()
			pst.setString(2, vo.getName()); // name -> vo.getName()
			pst.setInt(3, vo.getAge());
			pst.setInt(4, vo.getJno());
			pst.setString(5, vo.getInfo());
			pst.setDouble(6, vo.getPoint());
			pst.setString(7, vo.getBirthday());
			if ( pst.executeUpdate() > 0 )       // 처리한 Data 의 갯수 return
				 System.out.println("** Insert 성공 **");
			else System.out.println("** Insert 실패 **");
		} catch (Exception e) {
			System.out.println("** insert Exception => "+e.toString());
		}
	} //insert
	
	public static void main(String[] args) {

		// ** JDBC 
		// => Java 로 CRUD 구현
		// => Student List
		// => 순서 : DBConnection -> SQL구문처리 -> 결과처리
		selectList();
		joListSt(3);
		joListPst(3,"c");
	} //main
} //class
