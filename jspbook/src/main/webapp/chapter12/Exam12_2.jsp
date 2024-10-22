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
		String id = (String)request.getAttribute("ID");
		String pw = (String)request.getAttribute("passwd");
		String ms = (String)request.getAttribute("message");
	%>
	<p> <%=ms %>
	<p> 입력된 id 값 : <%=id %>
	<p> 입력된 pw 값 : <%=pw %>
</body>
</html>