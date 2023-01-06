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
	<h2>** Member Detail **</h2>
	<c:if test="${not empty apple}">
		<table>
			<tr height="40">
				<th bgcolor="Khaki">I D</th>
				<td>${apple.id}</td>
			</tr>
			<tr height="40">
				<th bgcolor="Khaki">Password</th>
				<td>${apple.password}</td>
			</tr>
			<tr height="40">
				<th bgcolor="Khaki">Name</th>
				<td>${apple.name}</td>
			</tr>
			<tr height="40">
				<th bgcolor="Khaki">Age</th>
				<td>${apple.age}</td>
			</tr>
			<tr height="40">
				<th bgcolor="Khaki">Jno</th>
				<td>${apple.jno}</td>
			</tr>
			<tr height="40">
				<th bgcolor="Khaki">Info</th>
				<td>${apple.info}</td>
			</tr>
			<tr height="40">
				<th bgcolor="Khaki">Point</th>
				<td>${apple.point}</td>
			</tr>
			<tr height="40">
				<th bgcolor="Khaki">Birthday</th>
				<td>${apple.birthday}</td>
			</tr>
		</table>

	</c:if>
	<c:if test="${empty apple}">
		<h3>** 출력할 정보가 없습니다. **</h3>
	</c:if>
	<hr>
	&nbsp;<a href="/Web02/mdetail?jCode=U&id=${apple.id}">내정보 수정</a>&nbsp;
	&nbsp;<a href="/Web02/logout">Logout</a>&nbsp;
	<c:if test="${sessionScope.loginID == 'admin'}">
	&nbsp;<a href="/Web02/mdelete?id=${apple.id}">추방</a>&nbsp;
	</c:if>
	<c:if test="${sessionScope.loginID != 'admin'}">
	&nbsp;<a href="/Web02/mdelete">회원탈퇴</a>&nbsp;
	</c:if>
	<hr>
	&nbsp;<a href="javascript:history.go(-1)">이전으로</a>&nbsp;
	&nbsp;<a href="/Web02/index.jsp">[Home]</a>&nbsp;

</body>
</html>