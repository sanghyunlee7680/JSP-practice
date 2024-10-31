<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String num = (String)request.getAttribute("num");
	%>
	<c:set var="num" value="<%=num %>"></c:set>
	<c:choose>
		<c:when test="${num%2==0 }">
			<c:out value="${num}"></c:out>은 짝수입니다.
		</c:when>
		<c:when test="${num%2==1}">
			<c:out value="${num}"></c:out>은 홀수입니다.
		</c:when>
		<c:otherwise>
			숫자가 아닙니다.
		</c:otherwise>
	</c:choose>
</body>
</html>