package controllerS;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StudentrService;
import vo.StudentrVO;


//** Student Detail

@WebServlet("/sdetail")
public class C02_sDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public C02_sDetail() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1) 요청분석 & 해당하는 Service 실행
		StudentrService service = new StudentrService();
		StudentrVO vo = new StudentrVO();
		String id = request.getParameter("id");
		vo.setId(id);
		vo = service.selectOne(vo);

		// 2) View (결과출력)
		request.setAttribute("apple", vo);
		request.getRequestDispatcher("student/studentDetail.jsp").forward(request, response);
	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}// class
