<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> -------- 기본 로케일 --------
		<fmt:setLocale value="ko"></fmt:setLocale>
		<fmt:setBundle basename="chapter09.resourceBundle.myBundle" var="resourceBundle"></fmt:setBundle>
	<p> 제목 : <fmt:message key="title" bundle="${resourceBundle}"></fmt:message>
	<p> <fmt:message key="username" var="userMsg" bundle="${resourceBundle}"></fmt:message>
		이름 : ${userMsg}
	<p> -------- 영문 로케일 --------	
		<fmt:setLocale value="en"></fmt:setLocale>
		<fmt:setBundle basename="chapter09.resourceBundle.myBundle" var="resourceBundle"></fmt:setBundle>
	<p> 제목 : <fmt:message key="title" bundle="${resourceBundle}"></fmt:message>
	<p> 이름 : <fmt:message key="username" bundle="${resourceBundle}"></fmt:message>
</body>
</html>