<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginForm" action="8_4" method="post" id="fm">
		<p> 아 이 디 : <input type="text" name="id" id="id">
		<p> 비밀번호 : <input type="text" name="passwd" id="pw">
		<p> <input type="button" value="전송" id="btn">
	</form>
	<script type="text/javascript">
		//step1) 셀렉하기
		let btn = document.querySelector("#btn");
		console.log(btn);
		//step2) 이벤트 할당하기
		btn.addEventListener("click", checkLogin)
		//step3) 함수기능
		function checkLogin(){
			//4-1 이벤트 할당하기
			let id = document.querySelector("#id").value;
			let pw = document.querySelector("#pw").value;
			let fm = document.querySelector("#fm");
			
			for(i=0; i<id.length; i++){
				let ch = id.charAt[i];
				console.log(ch);
				
				if((ch<'a'||ch>'z')&&(ch>'A'||ch<'Z')&&(ch>'0'||ch<'9')){
					alert("아이디는 영문 소문자만 입력 가능 합니다.");
					fm.id.select();
					return false;
				}
			}
			if(id.length < 4 || id.length > 12){
				alert("아이디는 4~12자 이내로 입력 가능합니다.")
				fm.id.select();
				return false
			}
			if(isNaN(pw)){
				alert("비밀번호는 숫자만 입력 가능합니다.");
				fm.pw.select();
				return false;
			}
			if(pw.length<4){
				alert("비밀번호는 4자리 이상으로 입력해야 합니다.");
				fm.pw.select();
				return false;
			}
			fm.submit();
		}
	</script>
</body>
</html>