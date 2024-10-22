<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4> 세션 삭제 전</h4>
	<%
		String userid = (String)session.getAttribute("id");
		String userpw = (String)session.getAttribute("pw");
		int time = (int)session.getAttribute("time");
		int time2 = (int)session.getAttribute("time2");
		String session_id = (String)session.getAttribute("session_id");
		long last = (long)session.getAttribute("last");
		long start = (long)session.getAttribute("start");
		long used = (long)session.getAttribute("used");
	%>
	<p> <%=userid%>님 환영합니다.
	<p> 설정된 세션의 속성 값 [1] : <%=userid %>
	<p> 설정된 세션의 속성 값 [2] : <%=userpw %>
	<p> 세션 유효시간 변경 전
	<p><%=time %>분<br>
	<h3>세션 유효시간 변경 후</h3>
	<p><%=time2 %>분<br>
	<%
		if(request.isRequestedSessionIdValid()==true){
			out.print("세션이 유효합니다.");
		} else { 
			out.print("세션이 유효하지 않습니다.");
		}
	
		session.invalidate();
	%>
	<p> 세션 아이디 : <%=session_id %>
	<p> 요청 시작 시간 : <%=start %>
	<p> 요청 마지막 시간 : <%=last %>
	<p> 웹 사이트의 경과 시간 : <%=used %>
	
	<h4> 세션 삭제 후</h4>
	
	<%
	
		if(request.isRequestedSessionIdValid()==true){
			out.print("세션이 유효합니다.");
		} else { 
			out.print("세션이 유효하지 않습니다.");
		}
	%>
</body>
</html>