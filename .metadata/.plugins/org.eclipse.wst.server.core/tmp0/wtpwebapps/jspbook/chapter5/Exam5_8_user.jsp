<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = (String)request.getAttribute("userid");
		String password = (String)request.getAttribute("userpw");
	%>
	<p> 아 이 디 :<% out.println(name); %>
	<p> 비밀번호 : <% out.println(password); %>
</body>
</html>