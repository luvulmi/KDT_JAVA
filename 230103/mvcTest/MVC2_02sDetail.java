package mvcTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
// ** Student Detail
 
@WebServlet("/sdetail2")
public class MVC2_02sDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MVC2_02sDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청분석 & 해당하는 Service 실행
		StudentService service = new StudentService();
		StudentVO vo = new StudentVO();
		String id=request.getParameter("id");
		vo.setId(id);
		vo=service.selectOne(vo);
		
		// 2) View 를 처리할 수 있도록 준비
		// => setAttribute , forward
		request.setAttribute("apple", vo);
		request.getRequestDispatcher("jsp08_MVCTest/mvc2_06sDetail.jsp").forward(request, response);
		 
	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
} //class
