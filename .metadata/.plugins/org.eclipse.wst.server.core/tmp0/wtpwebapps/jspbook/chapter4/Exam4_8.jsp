<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="chapter04.Exam04_7_Person" scope="request"></jsp:useBean>
	<p> 아이디 : <%=person.getId()%>
	<p> 이름 : <%=person.getName() %>
	
	<%
		person.setId(20230824);
		person.setName("홍길동");
	%>
	<jsp:include page="Exam4_7.jsp"></jsp:include>
</body>
</html>