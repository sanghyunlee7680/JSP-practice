<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4> 세션 삭제 전</h4>
	<%
		String userid = (String)session.getAttribute("id");
		String userpw = (String)session.getAttribute("pw");
		
	%>
	<p> <%=userid%>님 환영합니다.
	<p> 설정된 세션의 속성 값 [1] : <%=userid %>
	<p> 설정된 세션의 속성 값 [2] : <%=userpw %>
	
	<%
		session.removeAttribute("id");
	%>
	<h4> 세션 삭제 후</h4>
	<%
		userid=(String)session.getAttribute("id");
		userpw=(String)session.getAttribute("pw");
	%>
	<p> 설정된 세션의 속성 값 [1] : <%=userid %>
	<p> 설정된 세션의 속성 값 [2] : <%=userpw %>
</body>
</html>