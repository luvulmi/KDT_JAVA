package controllerM;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.MemberVO;

@WebServlet("/mupdate")
public class C06_mUpdate extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public C06_mUpdate() {
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 1) 요청분석 & 해당하는 Service 실행
      // => 한글처리 (post 요청시에도 현재 메서드 사용하기 때문)
      // => request의 Parameter 처리 -> vo 에 set
      request.setCharacterEncoding("UTF-8");
      String id=request.getParameter("id");
      String password=request.getParameter("password");
      String name=request.getParameter("name");
      int age=Integer.parseInt(request.getParameter("age"));
      int jno=Integer.parseInt(request.getParameter("jno"));
      String info=request.getParameter("info");
      double point=Double.parseDouble(request.getParameter("point"));
      String birthday=request.getParameter("birthday");
      
      
      MemberService service = new MemberService();
      MemberVO vo = new MemberVO();
      
      vo.setId(id); // 변수에 안담아도 됨.
      vo.setPassword(password);
      vo.setName(name);
      vo.setAge(age);
      vo.setJno(jno);
      vo.setInfo(info);
      vo.setPoint(point);
      vo.setBirthday(birthday);
      
      request.setAttribute("apple", vo);
      
      // 2) Service처리 (update)
      // => 성공
      // => 실패
      String uri="member/memberDetail.jsp";
      if (service.update(vo)>0) {
         vo.setId(id);
         if(request.getSession().getAttribute("loginName")!=null) {        	 
        	 request.getSession().setAttribute("loginName", vo.getName());
         }
         request.setAttribute("message", "~~ 내 정보 수정 성공, 로그인 후 이용하세요 ~~");
      } else {
         uri="member/updateForm.jsp";
         request.setAttribute("message", "~~ 수정 실패, Data 오류! 다시 하셈ㅋ ~~");
      }
      
      // 3) View로 Forward
      request.getRequestDispatcher(uri).forward(request, response);
       
   } //doGet

   // 추후에는 사용할 방식의 메서드만 생성하기
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

 
} //class