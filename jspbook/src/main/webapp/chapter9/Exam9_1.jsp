<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.NumberFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Locale locale = (Locale)request.getAttribute("locale");
		Date currentDate = (Date)request.getAttribute("currentDate");
		DateFormat dateFormat = (DateFormat)request.getAttribute("dateFormat");
		NumberFormat numberFormat = (NumberFormat)request.getAttribute("numberFormat");
	%>
	
	<p> 국가 : <%=locale.getDisplayCountry() %>
	<p> 날짜 : <%=dateFormat.format(currentDate) %>
	<p> 숫자 (12345.67) : <%=numberFormat.format(12345.67) %>
</body>
</html>