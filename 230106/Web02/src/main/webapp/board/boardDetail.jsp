<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Board Detail **</title>


</head>
<body>
	<h2>** Board Detail **</h2>
	<c:if test="${not empty bwrite}">
		<table>
			<tr height="40">
				<th bgcolor="Khaki">Seq</th>
				<td>${bwrite.seq}</td>
			</tr>
			<tr height="40">
				<th bgcolor="Khaki">I D</th>
				<td>${bwrite.id}</td>
			</tr>
			<tr height="40">
				<th bgcolor="Khaki">Title</th>
				<td>${bwrite.title}</td>
			</tr>
			<tr height="40">
				<th bgcolor="Khaki">Content</th>
				<td>${bwrite.content}</td>
			</tr>
			<tr height="40">
				<th bgcolor="Khaki">Regdate</th>
				<td>${bwrite.regdate}</td>
			</tr>
			<tr height="40">
				<th bgcolor="Khaki">Cnt</th>
				<td>${bwrite.cnt}</td>
			</tr>
		</table>

	</c:if>
	<c:if test="${empty bwrite}">
		<h3>** 출력할 정보가 없습니다. **</h3>
	</c:if>
	<hr>
	<c:if test="${sessionScope.loginID == bwrite.id}">
	&nbsp;<a href="/Web02/bdetail?jCode=U&seq=${bwrite.seq}">글 수정</a>&nbsp;
	&nbsp;<a href="/Web02/bdelete?seq=${bwrite.seq}">글 삭제</a>&nbsp;
	</c:if>
	&nbsp;<a href="javascript:history.go(-1)">이전으로</a>&nbsp;
	&nbsp;<a href="/Web02/index.jsp">[Home]</a>&nbsp;

</body>
</html>