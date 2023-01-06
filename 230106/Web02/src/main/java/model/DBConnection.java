package model;
import java.sql.Connection;
import java.sql.DriverManager;

//** DB 연결
//=> Connection 객체가 DB 연결및 연결정보를 관리함
// 즉, Connection 객체를 생성해야함

public class DBConnection {
	
	// ** Connection 객체 생성
	// => 일반적인 생성문 
	//	  Connection cn = new Connection_구현 클래스() => X
	// => DB 연결정보를 이용해서 생성 후 그 생성값을 전달 받아서 사용.
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	         String url="jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
	           // => allowPublicKeyRetrieval=true : local DB open 하지 않아도 connection 허용
	         System.out.println("===> JDBC Connection 성공  ===");
	           return DriverManager.getConnection(url,"root","myssql");
		}catch (Exception e) {
			System.out.println("*** JDBC Connection Exception =>" + e.toString());
			return null;
		}
	}//getConnection

}//class
