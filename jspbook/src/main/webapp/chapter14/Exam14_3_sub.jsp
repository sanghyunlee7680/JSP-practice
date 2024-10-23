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
		Cookie[] cookies = (Cookie[])request.getCookies();
	%>
	<p> 현재 설정된 쿠키의 개수 => <%=cookies.length %> <br>
	<p> ===============================================
	<%
		for(int i=0; i<cookies.length; i++){
			out.println("설정된 쿠키의 속성 이름 [ " + i + " ] : " + cookies[i].getName()+"<br>");
			out.println("설정된 쿠키의 속성 값 [ " + i + " ] : " + cookies[i].getValue()+"<br>");
			out.println("-----------------------------------------------------------<br>");
		}
	%>
</body>
</html>