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

@WebServlet("/bdelete")
public class C04_bDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public C04_bDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청분석 
		// 1.1) => login 정보 : session 에서 loginID 를 get 
		// 1.2) => 관리자 기능 : loginID == 'admin' and parameter 아이디가 존재하는 경우 
		request.setCharacterEncoding("UTF-8");
		int seq=Integer.parseInt(request.getParameter("seq"));
		
		BoardService service = new BoardService();
		BoardVO vo = new BoardVO();
		
		vo.setSeq(seq);
		
		// => 관리자에 의한 강제탈퇴 확인
	
		// 2) Service 실행
		// => 본인 탈퇴 : 반드시 session 처리 해야함
		// => 추방 : 반드시 세션 유지
		if ( service.delete(vo)>0 ) {
			//request.setAttribute("message", "~~ 회원 탈퇴 성공, 1개월 후 재가입 가능합니다. ~~");
			// => Redirect : message 를 session 에 보관하고 사용후에는 삭제해야함 (목적지인 index.jsp 에서)
			request.getSession().setAttribute("message", "~~ 게시글 삭제 완료. ~~");
		}else {
			request.setAttribute("message", "~~ 게시글 삭제 실패 , 다시하세요 ~~");
		}
		
		// 3) View 를 처리할 수 있도록 준비
		// => forward (성공, 실패 모두 index 로)
		String uri = "/Web02/blist";
		//request.getRequestDispatcher(uri).forward(request, response);
		response.sendRedirect(uri);
		 
	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
} //class
