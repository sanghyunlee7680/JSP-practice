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
		String id = (String)request.getAttribute("id");
		String pw = (String)request.getAttribute("pw");
		Cookie ck_id = (Cookie)request.getAttribute("ck_id");
		Cookie ck_pw = (Cookie)request.getAttribute("ck_pw");
	%>
	<p> 쿠키 생성이 성공했습니다.
	<p> <%=id %>님 환영합니다.
	<p> 아이디 : <%=id%>
	<p> 비밀번호 : <%=pw %>
	<p> 쿠키아이디 : <%=ck_id.getName() %>
	<p> 쿠키비밀번호 : <%=ck_pw.getValue() %>
</body>
</html>