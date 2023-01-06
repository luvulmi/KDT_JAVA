<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** BoadrList **</title>

</head>
<body>
	<h2>** BoadrList **</h2>
	<table width=100%>
		<tr bgcolor="YellowGreen">
			<th>Seq</th>
			<th>I D</th>
			<th>Title</th>
			<th>Regdate</th>
			<th>Cnt</th>
		</tr>
		<c:if test="${not empty blist}">
			<c:forEach var="s" items="${blist}">
				<tr>
					<td>${s.seq}</td>
					<td>${s.id}</td>
					<td><a href="/Web02/bdetail?seq=${s.seq}">${s.title}</a></td>
					<td>${s.regdate}</td>
					<td>${s.cnt}</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty blist}">
			<tr>
				<td colspan="6">** 출력할 자료가 1건도 없습니다. **</td>
			</tr>
		</c:if>
	</table>
	<hr>
	&nbsp;
	<a href="javascript:history.go(-1)">이전으로</a>&nbsp; &nbsp;
	<a href="/Web02/index.jsp">[Home]</a>&nbsp;


</body>
</html>