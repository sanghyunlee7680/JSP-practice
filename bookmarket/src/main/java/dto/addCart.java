package dto;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/addCart")
public class addCart extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전처리
		System.out.println("1.Connecting");
		String id = req.getParameter("id");
		// 변수의 유효성 검사 
		System.out.println("2.id:"+id);
		if(id==null || id.trim().equals("")) {
			resp.sendRedirect("books.jsp");
			return;
		}
		
		// 모델: 객체 생성
		BookRepository dao = BookRepository.getInstance();
		// 저장소에 있는지 확인
		Book book = dao.getBookById(id);
		System.out.println("3.book:"+book);
		// 변수 유효성 검사
		if(book==null) {
			resp.sendRedirect("exceptionNoBookId.jsp"); 
		}
		// 전부 다 주세요
		ArrayList<Book> goodsList = dao.getAllBooks(); 
		// 1. Book goods = new Book;
		// 	  goods = get();-> 복사본 생성: 원본유지
		// 2. Book goods = get();-> 원본사용: 객체
		
		// 복사본 DTO 생성
		Book goods = new Book(); 
		for(int i=0; i<goodsList.size(); i++) {
			goods = goodsList.get(i); // 옮겨 담음
			if(goods.getBookId().equals(id)){
				break;  // 해당 제품이 동일 하다면 for문 동작 중지
			}
		}
		HttpSession session = req.getSession();
		
		// session에서 cartlist를 가져온다.
		// 리스트가 없다면 새로운 ArrayList 객체를 생성하고
		// cartlist를 저장한다.
		// 첫 방문 시 동작 / 카트 생성
		ArrayList<Book> list = (ArrayList<Book>) session.getAttribute("cartlist");
		if(list==null) {
			list = new ArrayList<Book>();
			session.setAttribute("cartlist", list);
			System.out.println("list"+list);
		}

		int cnt=0;
		Book goodsQnt = new Book();
		
		// 장바구니에 추가할 때 장바구니에 동일상품(dto)이 있다면
		// 장바구니(ArrayList)에 있는 수량(Qnt)을 +1 한다
		// 객체를 추가하지 않는다. ( 수량이 증가함 )
		for(int i=0; i<list.size(); i++) {
			goodsQnt=list.get(i);
			if(goodsQnt.getBookId().equals(id)) {
				cnt++;
				int orderQuantity = goodsQnt.getQuantity() + 1;
				goodsQnt.setQuantity(orderQuantity);
				System.out.println("4.orderQuantity:"+orderQuantity);
				System.out.println("5.goodsQnt:"+goodsQnt);
			}
		}
		System.out.println("6.cnt:"+cnt);
		// 장바구니에 동일상품이 없다면 추가		
		if(cnt==0) {
			goods.setQuantity(1);
			list.add(goods);
		}
		System.out.println("7.goods:"+goods);
		
		
		resp.sendRedirect("book.jsp?id=" + id);
		System.out.println("추가되었습니다.");
//		session.setAttribute("id", id);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
//		RequestDispatcher rd = req.getRequestDispatcher("addBook.jsp");
//		rd.forward(req, resp);
	}

	

}
