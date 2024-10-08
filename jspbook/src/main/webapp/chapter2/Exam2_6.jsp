<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		Today's date :
		<! -- 객체를 출력할 수 있음 단 시간관련 객체가 아닌경우 주소가 출력됨 -->
		<%= new java.util.Date() %>
	</p>
</body>
</html>