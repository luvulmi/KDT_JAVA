package service;

import java.util.List;

import model.StudentrDAO;
import vo.GroupDTO;
import vo.StudentrVO;

//2번째
public class StudentrService {

	StudentrDAO dao = new StudentrDAO();

	// 1. selectList
	public List<StudentrVO> selectList() {
		// dao.selectList() 의 sql 구문 처리결과를 받아 Controller 로 전달
		return dao.selectList();
	} // selectList

	// 2. selectOnew : Detail
	public StudentrVO selectOne(StudentrVO vo) {
		return dao.selectOne(vo);
	}// selectOne

	// 3. insert
	public int insert(StudentrVO vo) {
		return dao.insert(vo);
	}// insert

	// 4. update
	public int update(StudentrVO vo) {
		return dao.update(vo);
	}// update

	// 5. delete
	public int delete(StudentrVO vo) {
		return dao.delete(vo);
	}// delete

	// 6. group
	public List<GroupDTO> groupTest() {
		return dao.groupTest();
	}// group

	// 7. Transaction Test
	public void transactionTest() {
		dao.transationTest();
	}// transactionTest

} // class
