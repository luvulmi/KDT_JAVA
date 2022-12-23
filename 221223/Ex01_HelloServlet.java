package servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex01_HelloServlet") // 요청명. 요청이 들어오면 자동 반응. 
// 요청방식 두 가지 : get , post 
public class Ex01_HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public Ex01_HelloServlet() {
        super();
    }

    // 요청이 들어오면 자동 실행되는 메서드.
    // 1. get 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ** 한글 처리
		response.setContentType("text/html; charset=UTF-8");
		
		// ** 출력문 ( response에 html 문서를 담아줌 )
		// => 출력객체 생성 -> html 문서작성
		
		PrintWriter out = response.getWriter();
		String name = "유리밍";
		
		out.print("<html><body>");
		out.print("<h1 style='color:red;'>*** Hello Servlet ***</h1>");
		out.print("<h1 style='color:blue;'>*** 이거 이상해요 ***</h1>");
		out.print("작성자 : "+name+"<br>");
		out.print("</body></html>");
		out.print("<h2>*** Servlet 장점 : Java 코드 처리 매우 편리 ***</h1>");
		out.print("<h2>*** Servlet 단점 : View (Html) 작성 매우 불편 ***</h1>");
		
	} // doGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	} // doPost

}// class
