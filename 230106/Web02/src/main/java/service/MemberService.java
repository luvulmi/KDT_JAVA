package service;

import java.util.List;

import model.MemberDAO;
import vo.MemberVO;

public class MemberService {
	MemberDAO dao = new MemberDAO();

	// 1. selectList
	public List<MemberVO> selectList() {
		// dao.selectList() 의 sql 구문 처리결과를 받아 Controller 로 전달
		return dao.selectList();
	} // selectList

	// 2. selectOnew : Detail
	public MemberVO selectOne(MemberVO vo) {
		return dao.selectOne(vo);
	}// selectOne

	// 3. insert
	public int insert(MemberVO vo) {
		return dao.insert(vo);
	}// insert

	// 4. update
	public int update(MemberVO vo) {
		return dao.update(vo);
	}// update

	// 5. delete
	public int delete(MemberVO vo) {
		return dao.delete(vo);
	}// delete

//	// 6. group
//	public List<GroupDTO> groupTest() {
//		return dao.groupTest();
//	}// group
//
//	// 7. Transaction Test
//	public void transactionTest() {
//		dao.transationTest();
//	}// transactionTest
}
