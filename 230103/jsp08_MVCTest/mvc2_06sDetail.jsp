<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Student Detail MVC2 **</title>
</head>
<body>
<h2>** Student Detail MVC2 **</h2>

<c:if test="${not empty apple}">
	<table>
		<tr height=30 ><th bgcolor="Yellow">I D</th><td>${apple.id}</td></tr>
		<tr height=30 ><th bgcolor="Yellow">Name</th><td>${apple.name}</td></tr>
		<tr height=30 ><th bgcolor="Yellow">Age</th><td>${apple.age}</td></tr>
		<tr height=30 ><th bgcolor="Yellow">Jno</th><td>${apple.jno}</td></tr>
		<tr height=30 ><th bgcolor="Yellow">Info</th><td>${apple.info}</td></tr>
		<tr height=30 ><th bgcolor="Yellow">Point</th><td>${apple.point}</td></tr>
		<tr height=30 ><th bgcolor="Yellow">BirthDay</th><td>${apple.birthday}</td></tr>
	</table>
</c:if>
<c:if test="${empty apple}">
	<h3>** 출력할 자료가 1건도 없습니다. **</h3>
</c:if>

</body>
</html>