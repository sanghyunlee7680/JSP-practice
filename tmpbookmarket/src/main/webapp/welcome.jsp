<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
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