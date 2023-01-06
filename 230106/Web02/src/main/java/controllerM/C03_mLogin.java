package controllerM;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.MemberVO;




//** Member Detail

@WebServlet("/login")
public class C03_mLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public C03_mLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1) 요청분석 & 해당하는 Service 실행
		MemberService service = new MemberService();
		MemberVO vo = new MemberVO();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		vo.setId(id);
		vo = service.selectOne(vo);
		// => id 존재: vo에는 모든 정보가 담겨짐
		// => id not : vo는 null
		
		// 2) Service 결과 처리
		// => 성공 -> Login정보 보관 후 index
		// => 실패 -> loginForm 재로그인 유도
		String uri="index.jsp";
		if(vo!=null) {
			// id 는 OK => password 확인
			if(vo.getPassword().equals(password)) {
				// 로그인 성공
				// => 로그인 정보 보관후 (session의 Attribute에 보관) , index
				request.getSession().setAttribute("loginID", vo.getId());
				request.getSession().setAttribute("loginName", vo.getName());
				request.setAttribute("message", "~안녕하슈?");
			} else {
				// 비밀번호 오류
				uri = "member/loginForm.jsp";
				request.setAttribute("message", "~ password 오류 !! 재입력");
			}
		}else {
			// id 오류
			uri = "member/loginForm.jsp";
			request.setAttribute("message", "~ id 오류 !! 재입력");
		}

		// 3) View (결과출력)
		request.getRequestDispatcher(uri).forward(request, response);
	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}// class
