<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	실습리스트
	<p>
		<a href="2_1">예제 2-1</a>
	</p>
	<p>
		<a href="2_2">예제 2-2</a>
	</p>
	<p>
		<a href="2_3">예제 2-3</a>
	</p>
	<p>
		<a href="2_4">예제 2-4</a>
	</p>
	<p>
		<a href="2_5">예제 2-5</a>
	</p>
	<p>
		<a href="2_6">예제 2-6</a>
	</p>
	<p>
		<a href="2_7">예제 2-7</a>
	</p>
	<hr></hr>
	<p>
		<a href="3_1">예제 3-1</a>
	</p>
	<p>
		<a href="3_2">예제 3-2</a>
	</p>
	<p>
		<a href="3_3">예제 3-3</a>
	</p>
	<p>
		<a href="3_4">예제 3-4</a>
	</p>
	<p>
		<a href="3_6">예제 3-6</a>
	</p>
	<p>
		<a href="3_7">예제 3-7</a>
	</p>
	<p>
		<a href="3_9">예제 3-9</a>
	</p>
	<p>
		<a href="3_10">예제 3-10</a>
	</p>
	<p>
		<a href="3_11">예제 3-11</a>
	</p>
	<hr></hr>
	<p>
		<a href="4_1">예제 4-1</a>
	</p>
	<p>
		<a href="4_2">예제 4-2</a>
	</p>
	<p>
		<a href="4_3">예제 4-3</a>
	</p>
	<p>
		<a href="4_4">예제 4-4</a>
	</p>
	<p>
		<a href="4_5">예제 4-5</a>
	</p>
	<p>
		<a href="4_6">예제 4-6</a>
	</p>
	<p>
		<a href="4_7">예제 4-7</a>
	</p>
	<p>
		<a href="4_8">예제 4-8</a>
	</p>
	<p>
		<a href="4_9">예제 4-9</a>
	</p>
	<p>
		<a href="4_10">예제 4-10</a>
	</p>
	<p>
		<a href="4_11">예제 4-11</a>
	</p>
	
	<form action="4_0" method="get">
		<p><input type="text" name="id"/>
		<p><input type="text" name="name"/>
		<p><input type="submit" value="전송"/>
	</form>
	<% 
		String id="cat";
		String name="dog";
	%>
	<p>
		<a href="4_0?id=${id}&name=<%=name%>">예제 4-0</a>
	</p>
	<hr></hr>
	
	<p>예제 5-1</p>
	<form action="5_1">
		<p> 아 이 디 : <input type="text" name="id">
		<p> 비밀번호 : <input type="text" name="passwd">
		<p> <input type="submit" value="전송"></p>
	</form>
	<p>
		<a href="5_2">예제 5-2</a>
	</p>
	<p>
		<a href="5_3">예제 5-3</a>
	</p>
	<h3>response 내장 객체</h3>
	<p>
		<a href="5_4">예제 5-4</a>
	</p>
	<p>
		<a href="5_5">예제 5-5</a>
	</p>
	<h3>out 내장 객체</h3>
	<p>
		<a href="5_7">예제 5-7</a>
	</p>
	<p>
		<a href="5_8">예제 5-8</a>
	</p>
	<h2>폼 태그</h2>
	<h3>input 태그</h3>
	<p>
		<a href="6_1">예제 6-1</a>
	</p>
	<h3>select 태그</h3>
	<p>
		<a href="6_2	">예제 6-2</a>
	</p>
</body>
</html>