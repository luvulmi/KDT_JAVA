<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** MemberUpdate Web02_MVC2 **</title>
</head>
<body>
	<h2>** MemberUpdate Web02_MVC2 **</h2>
	<form action="/Web02/bupdate" method="post">
		<table>
			<tr height="40">
				<td bgcolor="GreenYellow">Seq</td>
				<td><input type="text" name="seq" size="20" value="${bwrite.seq}"
					readonly="readonly"></td>
				<!-- ID 는 수정 불가 => input Tag 의 입력막기 
								-> readonly : 권장 (서버로 전송됨)
								-> disabled : 비추 (서버로 전송안됨)
		-->
			</tr>
			<tr height="40">
				<td bgcolor="GreenYellow">I D</td>
				<td><input type="password" name="id" size="20"
					value="${bwrite.id}" readonly="readonly"></td>
			</tr>
			<tr height="40">
				<td bgcolor="GreenYellow">Title</td>
				<td><input type="text" name="title" size="20"
					value="${bwrite.title}"></td>
			</tr>
			<tr height="40">
				<td bgcolor="GreenYellow">Content</td>
				<td><input type="text" name="content" size="20"
					value="${bwrite.content}"></td>
			</tr>
			<tr height="40">
				<td bgcolor="GreenYellow">Regdate</td>
				<td><input type="datetime" name="info" value="${bwrite.regdate}" readonly="readonly"></td>
			</tr>
			<tr height="40">
				<td bgcolor="GreenYellow">Cnt</td>
				<td><input type="text" name="cnt" size="20"
					value="${bwrite.cnt}" readonly="readonly"></td>
			</tr>
						<tr height="40">
				<td></td>
				<td><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
	<c:if test="${not empty requestScope.message}">
		<hr>
	=> ${requestScope.message}<br>
	</c:if>
	<hr>
	&nbsp;
	<a href="javascript:history.go(-1)">이전으로</a>&nbsp; &nbsp;
	<a href="/Web02/index.jsp">[Home]</a>&nbsp;
</body>
</html>