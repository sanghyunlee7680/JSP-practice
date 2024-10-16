<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginForm" action="8_3" method="post" id="fm">
		<p> 아 이 디 : <input type="text" name="id" id="id">
		<p> 비밀번호 : <input type="text" name="passwd" id="pw">
		<p> <input type="button" value="전송" id="btn">
	</form>
	<script type=text/javascript>
		let btn = document.querySelector("#btn");
		btn.addEventListener("click",checkLogin);
		
		function checkLogin(){
			let id = document.querySelector("#id").value;
			let pw = document.querySelector("#pw").value;
			let fm = document.querySelector("#fm");
			
			if(id.length<4||id.length>12){
				alert("아이디는 4~12자 이내로 입력 가능합니다.");
				fm.id.select();
				return false;
			}
			if(!isNaN(id.substr(0,1))){
				alert("이름은 숫자로 시작할 수 없습니다.");
				fm.id.select();
				return false;
			}
			if(pw.length<4){
				alert("비밀번호는 4자 이상으로 입력해야 합니다.");
				fm.pw.select();
				return false;
			}
			
			fm.submit();
		}
	</script>
</body>
</html>