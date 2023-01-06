package controllerB;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.MemberService;
import vo.BoardVO;
import vo.MemberVO;




//** Member Detail

@WebServlet("/bdetail")
public class C02_bDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public C02_bDetail() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1) 요청분석 & 해당하는 Service 실행
		// => 요청1) memBERlist 에서 : 요청 id가 Parameter로 전달
		// => 요청2) login 후 내정보 : session에서 loginID를 get
		
		// => 그러므로 parameter 확인 후 session 처리
		String id=request.getParameter("id");
		if( id==null || id.length()<1) {
			// ** session의 loginID 존재여부를 확인 후 getAtttribute
			if (request.getSession().getAttribute("loginID") != null) {
				id=(String)request.getSession().getAttribute("loginID");
			}else {
				request.setAttribute("message", " session 출력할 id 없음, 로그인 후 이용하셈ㅋ");
				request.getRequestDispatcher("member/loginForm.jsp").forward(request, response);
				return; // void 메서드에서 return -> 메서드 종료.
			}
		}
		// 2) service 실행 & 결과처리 (setAttribute)
		BoardService service = new BoardService();
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(request.getParameter("seq")));
		// vo=service.selectOne(vo);
		// request.setAttribute("apple", vo);
		request.setAttribute("bwrite", service.selectOne(vo));
		
		// 3) View 를 처리할 수 있도록 준비
		// => forward (Update 요청인 경우에는 updateForm.jsp로)
		// => parameter "jCode"는 없는 경우 null return 하며,
		//	  없는 경우가 많으므로 NullPointerException 예방에 주의
		
		String uri = "board/boardDetail.jsp";
		if("U".equals(request.getParameter("jCode"))) {
			uri="board/updateForm.jsp";
		}
		
		request.getRequestDispatcher(uri).forward(request, response);
		 
	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}// class
