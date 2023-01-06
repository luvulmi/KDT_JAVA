package controllerB;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.BoardVO;

@WebServlet("/bupdate")
public class C03_bUpdate extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public C03_bUpdate() {
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 1) 요청분석 & 해당하는 Service 실행
      // => 한글처리 (post 요청시에도 현재 메서드 사용하기 때문)
      // => request의 Parameter 처리 -> vo 에 set
      request.setCharacterEncoding("UTF-8");
      int seq=Integer.parseInt(request.getParameter("seq"));
      String id = request.getParameter("id");
      String title = request.getParameter("title");
      String content=request.getParameter("content");
      String regdate = request.getParameter("regdate");
      int cnt = Integer.parseInt(request.getParameter("cnt"));
       
      BoardService service = new BoardService();
      BoardVO vo = new BoardVO();
      
      vo.setSeq(seq);
      vo.setId(id);
      vo.setTitle(title);
      vo.setContent(content);
      vo.setRegdate(regdate);
      vo.setCnt(cnt);
      
      request.setAttribute("bwrite", vo);
      
      // 2) Service처리 (update)
      // => 성공
      // => 실패
      String uri="board/boardDetail.jsp";
      if (service.update(vo)>0) {
         request.setAttribute("message", "~~ 내 정보 수정 성공, 로그인 후 이용하세요 ~~");
      } else {
         uri="board/updateForm.jsp";
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