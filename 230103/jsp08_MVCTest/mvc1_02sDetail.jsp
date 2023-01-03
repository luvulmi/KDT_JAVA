<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="mvcTest.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** StudentDetail MVC1_JSP **</title>
<%
	StudentService service = new StudentService();
	StudentVO vo = new StudentVO();
	String id = request.getParameter("id");
	vo.setId(id);
	vo = service.selectOne(vo);
%>
</head>
<body>
<h2>** StudentDetail MVC1_JSP **</h2>
<%
   if (vo != null) {
%>
   Id : <%=vo.getId()%> <br>
   Name : <%=vo.getName()%><br>
   Age : <%=vo.getAge()%><br>
   Jno : <%=vo.getJno()%><br>
   Info : <%=vo.getInfo()%><br>
   Point : <%=vo.getPoint()%><br>
   BirthDay : <%=vo.getBirthday()%>

<%
   } else {
%>
   <h3>** 출력할 자료가 1건도 없습니다. **</h3>
<%
   }
%>
</body>
</html>