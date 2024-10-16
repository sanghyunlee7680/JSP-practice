let btn = document.getElementById("btn");
btn.addEventListener("click",CheckAddBook);

console.log(btn);

function CheckAddBook()
{
	let bookId = document.getElementById("bookId");
	let name = document.getElementById("name");
	let unitPrice = document.getElementById("unitPrice");
	let unitsInStock = document.getElementById("unitsInStock");
	let description = document.getElementById("description");
	
	console.log(bookId);
	console.log(name);
	console.log(unitPrice);
	console.log(unitsInStock);
	console.log(description);
	
	//도서아이디 체크
	if (!check(/^ISBN[0-9]{4,11}$/, bookId, "[도서 코드]\nISBN과 숫자를 조합하여 5~12자까지 입력하세요\n첫 글자는 반드시 ISBN로 시작하세요"))
		return false;
	
	//도서명 체크
	if (name.value.length<4 || name.value.length>50)
	{
		alert("[도서명]\n최소 4자에서 최대 50자까지 입력하세요.");
		name.focus();
		return false;
	}
	
	//도서 가격체크
	if (unitPrice.value.length==0 || isNaN(unitPrice.value))
	{
		alert("[가격]\n숫자만 입력하세요.");
		unitPrice.focus();
		return false;
	}
	
	if (unitPrice.value < 0)
	{
		alert("[가격]\n음수를 입력할 수 없습니다.");
		unitPrice.focus();
		return false;
	}
	
	//재고 수 체크
	if (isNaN(unitsInStock.value))
	{
		alert("[재고수]\n숫자만 입력하세요");
		unitsInStock.focus();
		return false;
	}
	
	if(description.value.length < 100)
	{
		alert("[상세설명]\n최소 100자 이상 입력하세요.")
		description.focus();
		return false;
	}
	
	function check(regExp, e, msg)
	{
		if (regExp.test(e.value))
		{
			return true;
		}
		alert(msg);
		e.focus();
		return false;
	}
	
	document.newBook.submit();
}