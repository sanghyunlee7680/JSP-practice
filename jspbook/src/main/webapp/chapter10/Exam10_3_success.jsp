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
		String remoteUser = (String)request.getAttribute("remoteUser");
		String authType = (String)request.getAttribute("authType");
		boolean UserInRole = (boolean)request.getAttribute("userInRole");
		boolean UserInRole2 = (boolean)request.getAttribute("userInRole2");
	%>


	<p> 사용자명 : <%=remoteUser %>
	<p> 인증방법 : <%=authType %>
	<p> 인증한 사용자명이 역할명 "guest"에 속하는 사용자인가요?
		<%=UserInRole %>
	<p> 인증한 사용자명이 역할명 "manager"에 속하는 사용자인가요?
		<%=UserInRole2 %>
</body>
</html>