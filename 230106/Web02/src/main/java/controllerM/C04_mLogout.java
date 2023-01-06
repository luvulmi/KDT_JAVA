package controllerM;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




//** Member Detail

@WebServlet("/logout")
public class C04_mLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public C04_mLogout() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1) 요청분석 & 해당하는 Service 실행
		// => Logout: session 무효화, index
		// => session 객체 정의
		//	 -> request.getSession() 메서드의 매개변수 사용
		//	 -> 매개변수 없음과 true는 동일 : session이 없을 때 생성해서 제공
		//	 -> false: session이 없을때 null return
		//						(사용전에 반드시 null 확인해야함 -> NullPointerException)
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
			request.setAttribute("message", "로그아웃 완료");
		}
		
		String uri = "index.jsp";
		
		request.getRequestDispatcher(uri).forward(request, response);
	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}// class
