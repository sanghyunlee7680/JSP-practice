<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	System.out.println("2.login.jsp로 이동함");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입 양식</h1>
	<form action="join" method="post">
		<p> ID : <input type="text" name="id">
		<p> PW : <input type="text" name="pw">
		<p> 나이 : <input type="text" name="age">
		<p> <input type="submit" value="회원가입">
	</form>
</body>
</html>