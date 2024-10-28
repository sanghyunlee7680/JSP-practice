<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ch16_dto.ch16_dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ch16_dto dto = (ch16_dto)request.getAttribute("DTO");
	%>
	<form action="update" method="post">
		<p> ID : <input type="text" value="<%=dto.getId()%>" name="id" readonly>
		<p> PW : <input type="text" value="<%=dto.getPw()%>" name="pw">
		<p> 이름 : <input type="text" value="<%=dto.getName()%>" name="name">
		<p> <input type="submit" value="가입">
	</form>
</body>
</html>