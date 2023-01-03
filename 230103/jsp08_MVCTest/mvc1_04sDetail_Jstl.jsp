<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mvcTest.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Student Detail MVC1_JSTL,EL **</title>
<%
	StudentService service = new StudentService();
	StudentVO vo = new StudentVO();
	String id = request.getParameter("id");
	vo.setId(id);
	vo = service.selectOne(vo);
	pageContext.setAttribute("student", vo);
%>
</head>
<body>
<h2>** Student Detail MVC1_JSTL & EL **</h2>

<c:if test="${not empty student}">
	<table>
		<tr height=30 ><th bgcolor="Yellow">I D</th><td>${student.id}</td></tr>
		<tr height=30 ><th bgcolor="Yellow">Name</th><td>${student.name}</td></tr>
		<tr height=30 ><th bgcolor="Yellow">Age</th><td>${student.age}</td></tr>
		<tr height=30 ><th bgcolor="Yellow">Jno</th><td>${student.jno}</td></tr>
		<tr height=30 ><th bgcolor="Yellow">Info</th><td>${student.info}</td></tr>
		<tr height=30 ><th bgcolor="Yellow">Point</th><td>${student.point}</td></tr>
		<tr height=30 ><th bgcolor="Yellow">BirthDay</th><td>${student.birthday}</td></tr>
	</table>
</c:if>
<c:if test="${empty student}">
	<h3>** 출력할 자료가 1건도 없습니다. **</h3>
</c:if>

</body>
</html>