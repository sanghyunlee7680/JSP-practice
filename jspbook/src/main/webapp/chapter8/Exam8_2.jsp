<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginForm" action="8_2" method="post" id="loginform">
		<p> 아 이 디 : <input type="text" name="id" id="id">
		<p> 비밀번호 : <input type="text" name="passwd" id="pw">
		<p> <input type="button" value="전송" id="btn" onclick="checkLogin()">
	</form>
	<script type="text/javascript">
		//1.셀렉하기
		let btn = document.querySelector("#btn");
		//2.이벤트 할당
		btn.addEventListener("click", checkLogin);
		//3.함수
		
		function checkLogin()
		{
			//4-1.html.value 읽어오기위해 셀렉
			let id = document.querySelector("#id").value;
			let pw = document.querySelector("#pw").value;
			let form = document.querySelector("#loginform");
			console.log(id);
			console.log(pw);
			if(id=="")
			{
				alert("아이디를 입력해주세요. ");
				form.id.focus();
				return false;
			}
			else if(pw=="")
			{
				alert("비밀번호를 입력해주세요. ");
				form.pw.focus();
				return false;
			}
			form.submit();
		}	
	</script>
</body>
</html>