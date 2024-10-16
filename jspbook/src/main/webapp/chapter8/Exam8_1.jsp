<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginForm">
		<p> 아 이 디 : <input type="text" name="id" id="log">
		<p> 비밀번호 : <input type="text" name="passwd" id="pw">
		<p> <input type="submit" value="전송"  id="sbt">
	</form>
	<script type="text/javascript">
		//step1) 셀렉하기
		let sbt = document.querySelector("#sbt");
		//step2) 이벤트 할당하기
		sbt.addEventListener("click",checkForm);
		//step3) 함수()
		function checkForm(){
			//step4) html.value 읽어오기
			//step4-1)셀렉하기 및 
			let id = document.querySelector("#log").value;
			let pw = document.querySelector("#pw").value;
			
			//step4-2)읽어오기
			alert("아이디 : " + id + "\n" + "비밀번호 : " + pw);
		}
		
	</script>
</body>
</html>