<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** MemberJoin Web02_MVC2 **</title>
</head>
<body>
	<h2>** MemberJoin Web02_MVC2 **</h2>
	<form action="/Web02/join" method="post">
		<table>
			<tr height="40">
				<td bgcolor="LightBlue">I D</td>
				<td><input type="text" name="id" size="20"
					placeholder="영문과 숫자 10자 이내"></td>
			</tr>
			<tr height="40">
				<td bgcolor="LightBlue">Password</td>
				<td><input type="password" name="password" size="20"
					placeholder="특수문자 포함 10자 이내"></td>
			</tr>
			<tr height="40">
				<td bgcolor="LightBlue">Name</td>
				<td><input type="text" name="name" size="20"
					placeholder="영문과 한글 10자 이내"></td>
			</tr>
			<tr height="40">
				<td bgcolor="LightBlue">Age</td>
				<td><input type="text" name="age" size="20" placeholder="정수"></td>
			</tr>
			<tr height="40">
				<td bgcolor="LightBlue">Jno</td>
				<td><select name="jno">
						<option value="1">1:굉장해엄청나</option>
						<option value="2">2:구해조</option>
						<option value="3">3:백업은 기본이조</option>
						<option value="4">4:상호형 빵사조</option>
						<option value="5">5:(주) 식빵</option>
				</select></td>
			</tr>
			<tr height="40">
				<td bgcolor="LightBlue">Info</td>
				<td><input type="text" name="info" size="20" placeholder="자기소개"></td>
			</tr>
			<tr height="40">
				<td bgcolor="LightBlue">Point</td>
				<td><input type="text" name="point" size="20" placeholder="실수"></td>
			</tr>
			<tr height="40">
				<td bgcolor="LightBlue">Birthday</td>
				<td><input type="date" name="birthday" size="20"></td>
			</tr>
			<tr height="40">
				<td bgcolor="LightBlue">I D</td>
				<td><input type="submit" value="가입">&nbsp;&nbsp;
				<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
	<c:if test="${not empty requestScope.message}">
	<hr>
	=> ${requestScope.message}
	</c:if>
	<hr>
	&nbsp;<a href="javascript:history.go(-1)">이전으로</a>&nbsp;
	&nbsp;<a href="/Web02/index.jsp">[Home]</a>&nbsp;
</body>
</html>