package service;

import java.util.List;

import model.BoardDAO;
import vo.BoardVO;

public class BoardService {
	BoardDAO dao = new BoardDAO();

	// 1. selectList
	public List<BoardVO> selectList() {
		// dao.selectList() 의 sql 구문 처리결과를 받아 Controller 로 전달
		return dao.selectList();
	} // selectList

	// 2. selectOnew : Detail
	public BoardVO selectOne(BoardVO vo) {
		return dao.selectOne(vo);
	}// selectOne

	// 3. insert
	public int insert(BoardVO vo) {
		return dao.insert(vo);
	}// insert

	// 4. update
	public int update(BoardVO vo) {
		return dao.update(vo);
	}// update

	// 5. delete
	public int delete(BoardVO vo) {
		return dao.delete(vo);
	}// delete
}
