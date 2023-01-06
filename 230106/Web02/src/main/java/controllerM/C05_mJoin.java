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

@WebServlet("/join")
public class C05_mJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public C05_mJoin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1) 요청분석 & 해당하는 Service 실행
		// => 한글처리 (post 요청시에도 현재메서드 사용하기 때문)
		// => request의 Parameter 처리 -> vo에 set
		request.setCharacterEncoding("UTF-8");
		String id= request.getParameter("id");
		String password= request.getParameter("password");
		String name= request.getParameter("name");
		int age =Integer.parseInt(request.getParameter("age"));
		int jno = Integer.parseInt(request.getParameter("jno"));
		String info= request.getParameter("info");
		double point = Double.parseDouble(request.getParameter("point"));
		String birthday = request.getParameter("birthday");
		
		
		MemberService service = new MemberService();
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setAge(age);
		vo.setJno(jno);
		vo.setInfo(info);
		vo.setPoint(point);
		vo.setBirthday(birthday);
		
		// 2) Service 결과 처리
		// => 성공 -> Login 유도 -> loginForm
		// => 실패 -> 재가입 유도 -> joinForm
		String uri="member/loginForm.jsp";
		if(service.insert(vo)>0) {
			request.setAttribute("message", "회원가입 성공했수다.");
		} else {
			uri ="member/joinForm.jsp";
			request.setAttribute("message", "실패했수다 다시 시도하시구려");
		}
				
		// 3) View (결과출력)
		request.getRequestDispatcher(uri).forward(request, response);
	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}// class
