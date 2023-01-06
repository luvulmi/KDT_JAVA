package controllerB;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.BoardVO;






@WebServlet("/blist")
public class C01_bList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public C01_bList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//요청분석 서비스실행
		BoardService service = new BoardService();
		List<BoardVO> list = service.selectList();

		// 2) View 처리준비
		//=>
		request.setAttribute("blist",list);
		request.getRequestDispatcher("board/boardList.jsp").forward(request, response);
		
		
		

	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}// class
