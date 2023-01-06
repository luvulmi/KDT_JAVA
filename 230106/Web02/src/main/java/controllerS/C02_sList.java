package controllerS;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StudentrService;
import vo.StudentrVO;






@WebServlet("/slist")
public class C02_sList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public C02_sList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//요청분석 서비스실행
		StudentrService service = new StudentrService();
		List<StudentrVO> list = service.selectList();

		// 2) View 처리준비
		//=>
		request.setAttribute("slist",list);
		request.getRequestDispatcher("student/studentList.jsp").forward(request, response);
		
		
		

	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}// class
