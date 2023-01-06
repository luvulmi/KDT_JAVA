package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.BoardVO;


public class BoardDAO {
	// ** 전역변수 정의
		private static Connection cn=DBConnection.getConnection();
		private static Statement st;
		private static PreparedStatement pst;
		private static ResultSet rs;
		private static String sql;
		
		// 1. selectList
		public List<BoardVO> selectList() {
			sql="select seq, title, id, regdate, cnt from board order by seq desc";
			List<BoardVO> list = new ArrayList<BoardVO>();
			try {
				st=cn.createStatement();
				rs=st.executeQuery(sql);
				if (rs.next()) {
					do {
						BoardVO vo = new BoardVO(); 
						vo.setSeq(rs.getInt(1));  
						vo.setTitle(rs.getString(2));
						vo.setId(rs.getString(3));
						vo.setRegdate(rs.getString(4));
						vo.setCnt(rs.getInt(5));
						list.add(vo);
					}while(rs.next());
				}else {
					System.out.println("** selectList : 출력자료가 1건도 없음 **");
					list=null;
				}
			} catch (Exception e) {
				System.out.println("** selectList Exception => "+e.toString());
				list=null;
			}
			return list;
		} //selectList
		
		// 2. selectOne : Detail
		public BoardVO selectOne(BoardVO vo) {
			sql = "select * from board where seq=?";
			try {
				pst=cn.prepareStatement(sql);
				pst.setInt(1, vo.getSeq());
				rs=pst.executeQuery();
				if ( rs.next() ) {
					// select 성공
					vo.setSeq(rs.getInt(1));  
					vo.setTitle(rs.getString(2));
					vo.setId(rs.getString(3));
					vo.setContent(rs.getString(4));
					vo.setRegdate(rs.getString(5));
					vo.setCnt(rs.getInt(6));
				}else {
					// select 실패
					vo=null;
				}
			} catch (Exception e) {
				System.out.println("** selectOne Exception => "+e.toString());
				vo=null;
			}
			return vo;
		} //selectOne

		// 3. insert
		public int insert(BoardVO vo) {
			sql="insert into board (id,title,content) values(?,?,?)";
			try {
				pst=cn.prepareStatement(sql);
				pst.setString(1, vo.getId());
				pst.setString(2, vo.getTitle());
				pst.setString(3, vo.getContent());
				return pst.executeUpdate();
			} catch (Exception e) {
				System.out.println("** insert Exception => "+e.toString());
				return 0;
			}
		} //insert
		
		// 4. update
		public int update(BoardVO vo) {
			sql="update board set title=?, content=?, regdate=current_timestamp where seq=?";
			try {
				pst=cn.prepareStatement(sql);
				pst.setString(1, vo.getTitle());	
				pst.setString(2, vo.getContent());	
				pst.setInt(3, vo.getSeq());	
				return pst.executeUpdate();
			} catch (Exception e) {
				System.out.println("** update Exception => "+e.toString());
				return 0;
			}
		} //update
		
		// 5. delete
		public int delete(BoardVO vo) {
			sql="delete from board where seq=?";
			try {
				pst=cn.prepareStatement(sql);
				pst.setInt(1, vo.getSeq());
				return pst.executeUpdate();
			} catch (Exception e) {
				System.out.println("** delete Exception => "+e.toString());
				return 0;
			}
		} //delete
}
