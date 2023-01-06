<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** MemberList MVC2 **</title>
</head>
<body>
<h2>** MemberList Web02_MVC2 **</h2>
<table width=100%>
	<tr bgcolor="YellowGreen">
		<th>I D</th><th>Password</th><th>Name</th><th>Age</th>
		<th>Jno</th><th>Info</th><th>Point</th><th>Birthday</th>
	</tr>
  <c:if test="${not empty mlist}">
  	<c:forEach var="s" items="${mlist}">
  	<tr>
		<td><a href="/Web02/mdetail?id=${s.id}">${s.id}</a></td>
		<td>${s.password}</td><td>${s.name}</td><td>${s.age}</td><td>${s.jno}</td>
		<td>${s.info}</td><td>${s.point}</td><td>${s.birthday}</td>
	</tr>
  	</c:forEach>
  </c:if>	
  <c:if test="${empty mlist}">
	<tr><td colspan="7">** 출력할 자료가 1건도 없습니다. **</td></tr>
  </c:if>
</table>
<hr>
&nbsp;<a href="javascript:history.go(-1)">이전으로</a>&nbsp;
&nbsp;<a href="/Web02/index.jsp">[Home]</a>&nbsp;
</body>
</html>