<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Hello JSP **</title>
</head>
<body>
	<h1>** Hello JSP **</h1>
	<img alt="merry" src="../images/christmas.png" width=400 height=300>
	<h2>** 안녕들하신가우 **</h2>
	<h2>** Java Code **</h2>
	<% String name = "Merry Christmasssssssssss";
		int i = 12*25;
	%>
	<h2>Name : <%= name %></h2>
	<h2>i 결과 : <%= i%></h2>
	
	<h3>* JSP 장점 : View Html 작성 매우 편리*</h2>
	<h3>* JSP 단점 : Java code 작성 매우 불편*</h2>
</body>
</html>