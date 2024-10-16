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
		String name = (String)request.getAttribute("name");
		String phone1 = (String)request.getAttribute("phone1");
		String phone2 = (String)request.getAttribute("phone2");
		String phone3 = (String)request.getAttribute("phone3");
		String email = (String)request.getAttribute("email");
		
	%>
	
	<h3>회원 가입 성공!!</h3>
	
	<p> ID : <%=id %>
	<p> PW : <%=pw %>
	<p> 이름 : <%=name %>
	<p> 전화번호 : <%=phone1 %>-<%=phone2%>-<%=phone3 %>
	<p> 이메일 : <%=email %>
</body>
</html>