<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
	<h2>** Student Detail **</h2>
	<c:if test="${not empty apple}">
		<table>
			<tr><th bgcolor="yellow">I D</th><td>${apple.id}</td>
			<tr><th bgcolor="yellow">Name</th><td>${apple.name}</td>
			<tr><th bgcolor="yellow">Age</th><td>${apple.age}</td>
			<tr><th bgcolor="yellow">Jno</th><td>${apple.jno}</td>
			<tr><th bgcolor="yellow">Info</th><td>${apple.info}</td>
			<tr><th bgcolor="yellow">Point</th><td>${apple.point}</td>
			<tr><th bgcolor="yellow">Birthday</th><td>${apple.birthday}</td>
			</tr>
				</table>
	
	</c:if>



</body>
</html>