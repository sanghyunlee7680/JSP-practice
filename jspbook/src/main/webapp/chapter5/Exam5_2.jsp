<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<%
	// Enumeration은 대부분 이 구조만 사용한다.
		Enumeration en = request.getHeaderNames();
		while (en.hasMoreElements()){
			String headerName = (String) en.nextElement();
			String headerValue = request.getHeader(headerName);
	%>
	<%=headerName %> : <%=headerValue %><br>
	<%
		}
	%>

</body>
</html>