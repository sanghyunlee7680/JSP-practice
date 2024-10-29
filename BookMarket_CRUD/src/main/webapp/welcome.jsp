<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%
	response.setIntHeader("Refresh",5);
	Date day = new java.util.Date();
	String am_pm;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 정적 리소스는 절대경로표시를 추천함 -->
<link rel="stylesheet" href="/BookMarket_CRUD/resources/css/bootstrap.min.css"/>
</head>
<body>
	<div class="container py-4">
		<%@ include file="menu.jsp" %>
		<%! 
		String greeting = "Welcome to Book Shopping Mall"; 
		String tagline = "Welcome to Web Market!";
		%>
		<div class="container-fluid py-5">
			<h1 class="display-5 fw-bold"><%=greeting  %></h1>
			<p class="col-md-8 fs-4">BookMarket</p>
		</div>
		<div class="row align-items-md-stretch text-center">
			<div class="col-md-12">
				<div class="h-100 p-5">
					<h3><%=tagline  %></h3>
				</div>
			</div>
		</div>
		<%@ include file = "footer.jsp" %>
	</div>
</body>
</html>