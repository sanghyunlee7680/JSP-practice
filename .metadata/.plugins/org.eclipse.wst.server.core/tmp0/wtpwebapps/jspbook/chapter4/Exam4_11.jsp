<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="chapter04.Exam04_11"></jsp:useBean>
	<jsp:setProperty name="person" property="id" value="20230824"></jsp:setProperty>
	<jsp:setProperty name="person" property="name" value="홍길동"></jsp:setProperty>
	<p> 아이디 : <jsp:getProperty property="id" name="person"></jsp:getProperty>
	<p> 이 름 : <jsp:getProperty property="name" name="person"></jsp:getProperty>
</body>
</html>