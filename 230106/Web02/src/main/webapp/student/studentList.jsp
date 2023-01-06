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
	<h2>** StudentList **</h2>
	<table width=100%>
		<tr bgcolor="Lime">
			<th>I D</th>
			<th>Name</th>
			<th>Age</th>
			<th>Jno</th>
			<th>Info</th>
			<th>Point</th>
			<th>Birthday</th>
		</tr>

		<c:if test="${not empty slist}">
			<c:forEach var="s" items="${slist}" varStatus="vs">
				<tr>
					<td><a href="sdetail?id=${s.id}">${s.id}</a></td>
					<td>${s.name}</td>
					<td>${s.age}</td>
					<td>${s.jno}</td>
					<td>${s.info}</td>
					<td>${s.point}</td>
					<td>${s.birthday}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>



</body>
</html>