package jdbc02;

import java.util.List;

public class StudentService {
	
	StudentDAO dao = new StudentDAO();
	
	// 1. selectList
	public List<StudentVO> selectList() {
//		dao.selectList()의 sql 구문 처리결과를 받아 Controller로 전달.
		return dao.selectList();
	} // selectList
	
	// 2. selectOne : Detail
	public StudentVO selectOne(StudentVO vo) {
		return dao.selectOne(vo);
	}//selectOne
	
	// 3. insert
	public int insert(StudentVO vo) {
		return dao.insert(vo);
	}// insert
	
	// 4. update
	public int update(StudentVO vo) {
		return dao.update(vo);
	}// update
	
	// 5. delete
	public int delete(StudentVO vo) {
		return dao.delete(vo);
	}// delete
	
	// 6. Group
	public List<GroupDTO> groupTest() {
		return dao.groupTest();
	} // groupTest
	
	// 7. Transacion Test
	public void transactionTest() {
		dao.transactionTest();
	}// Transacion Test
	
}//class