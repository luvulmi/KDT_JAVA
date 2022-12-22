package jdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc1.DBConnection;

//** DAO(Data Access Object)
//=> SQL ���� ó��
//=> CRUD ���� 
// Create(insert), Read(select), Update, Delete

public class StudentDAO {

	// ** �������� ����
	private static Connection cn = DBConnection.getConnection(); // dbconnection �������.
	private static Statement st; // sql�� ó��.
	private static PreparedStatement pst; // sql�� ó��. ó��ȿ���� �� ����.
	private static ResultSet rs; // ���� ����� ó��.
	private static String sql;

	// 1. selectList
	// => ó�� ����� ��� ������ List �ʿ�.
	public List<StudentVO> selectList() { // ����Ÿ�� List, StudentVO Ÿ������ ����.
		sql = "select * from student";

		// ** List ����.
		// => �ϰ� ����ó���� ���� ������ Collection : ArrayList ���.
		List<StudentVO> list = new ArrayList<StudentVO>();
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			// 3) ���ó��
			// => select ���� ����� �ִ��� Ȯ��.
			if (rs.next()) {
				// select�� ��� ���� => List�� ��� ����(Service -> Controller)
				do { // List �� ������ �� ����.

					StudentVO vo = new StudentVO(); // �ּҸ� ����.
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
				// select�� ��� ����
				System.out.println("** selectList : ����ڷᰡ 1�ǵ� ���� **");
				list = null;
			}
		} catch (Exception e) {
			System.out.println("** selectList Exception => " + e.toString());
			list = null;

		}
		return list;
	}// selectList

//	2. selectOne : Detail
//	=> id�� �̿��ؼ� selectOne �� ���  return
	public StudentVO selectOne(StudentVO vo) {
		sql = "select * from student where id=?";

		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			rs = pst.executeQuery();
			if (rs.next()) {
				// select ����
				vo.setId(rs.getString(1));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt(3));
				vo.setJno(rs.getInt(4));
				vo.setInfo(rs.getString(5));
				vo.setPoint(rs.getDouble(6));
				vo.setBirthday(rs.getString(7));
			} else {
				// select ����
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

			return pst.executeUpdate(); // ���� �� 1 ����. �޼��� ���� Ÿ���� int���̹Ƿ�.

		} catch (Exception e) {
			System.out.println("** selectOne Exception => " + e.toString());
			return 0; // �Է��̳� �������� ���� �� ��� 0
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
			return pst.executeUpdate(); // ���� �� 1 ����. �޼��� ���� Ÿ���� int���̹Ƿ�.
		} catch (Exception e) {
			System.out.println("** update Exception => " + e.toString());
			return 0; // �Է��̳� �������� ���� �� ��� 0
		}
	}// update

	// 5. delete
	public int delete(StudentVO vo) {
		sql = "delete from student where id=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			return pst.executeUpdate(); // ���� �� 1 ����. �޼��� ���� Ÿ���� int���̹Ƿ�.
		} catch (Exception e) {
			System.out.println("** delete Exception => " + e.toString());
			return 0; // �Է��̳� �������� ���� �� ��� 0
		}
	}// delete

} // class
