<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원 가입</h3>
	<form action="8_5" method="post" name="Member" id="fm">
		<p> 아 이 디 : <input type="text" name="id" id="id">
		<p> 비밀번호 : <input type="text" name="pw" id="pw">
		<p> 이	름 : <input type="text" name="name" id="name">
		<p> 연 락 처 : <select name="phone1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="019">019</option>
					 </select> 
					 - 
					 <input type="text" maxlength="4" size="4" name="phone2">
					 -
					 <input type="text" maxlength="4" size="4" name="phone3">
		<p> 이 메 일 : <input type="text" name="email" id="email">
		<p> <input type="button" value="가입하기" id="btn">
		
		<script>
			//셀렉
			let btn = document.querySelector("#btn");
			console.log(btn);
			//이벤트 할당
			btn.addEventListener("click",checkLogin);
			//함수
			function checkLogin()
			{
				let regExpId=/^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
				let regExpName=/^[가-힣]*$/;
				let regExpPw = /^[0-9]*$/;
				let regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/;
				let regExpEmail = /^[0-9a-zA-Z]([-_/.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_/.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
				
				let fm = document.querySelector("#fm");
				
				let id = document.querySelector("#id").value;
				let name = document.querySelector("#name").value;
				let pw = document.querySelector("#pw").value;
				
				let phone = fm.phone1.value + "-" + fm.phone2.value + "-" + fm.phone3.value;
				let email = document.querySelector("#email").value;
				
				console.log(fm);
				console.log(id);
				console.log(name);
				console.log(pw);
				console.log(phone);
				console.log(email);
				
				console.log(regExpPw);
				
				if(!regExpId.test(id))
				{
					alert("아이디는 문자로 시작해주세요.");	
					fm.id.select();
					return false;
				}
				if(!regExpName.test(name))
				{
					alert("이름은 한글만 입력해주세요.");
					fm.name.select();
					return false;
				}
				if(!regExpPw.test(pw))
				{
					alert("비밀번호는 숫자만 입력해주세요.");
					fm.pw.select();
					return false;
				}
				if(!regExpPhone.test(phone))
				{
					alert("연락처 입력을 확인해주세요.");
					return false;
				}
				if(!regExpEmail.test(email))
				{
					alert("이메일 입력을 확인해주세요.");
					fm.email.select();
					return false;
				}
				fm.submit();
			}
			
		</script>
	
	</form>
</body>
</html>