package dao;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import dto.Book;

public class BookRepository 
{
	//싱글톤
	private static BookRepository instance = new BookRepository(); 
	public static BookRepository getInstance() 						
	{	
		return instance;
	}
	
	
	public Connection DBconn() {
		// DB 연결
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String db = "jdbc:mysql://localhost:3306/bookmarketdb";
			String id="root";
			String pw="1234";
			
			conn = DriverManager.getConnection(db, id, pw);
			System.out.println("데이터 베이스 연결완료");
		} catch (Exception e) {
			System.out.println("DB 연결이 실패했습니다.");
			System.out.println("SQLException: " + e.getMessage());
		}
		return conn;
	}
	
	//생성자
	public BookRepository(){}
	
	// 전체 책DTO를 ArrayList에 묶어서 전송
	public ArrayList<Book> getAllBooks()
	{	
		//Book 객체 묶음, 메소드 안에 넣어 ArrayList가 중복되어 쌓이는 걸 방지
		ArrayList<Book> listOfBooks = new ArrayList<Book>();
		// Step 1) 데이터 베이스 연결
		Connection conn = DBconn();
		// Step 2) 쿼리 전송
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				// DTO 변수이름, Repository 변수이름, Database 컬럼 이름이 같아야한다. 
				// 변수 < DTO < ArrayList<DTO>
				String bookId = rs.getString("bookId");			//도서 ID
				String bookname = rs.getString("bookname");			//도서명
				int unitPrice = rs.getInt("unitPrice"); 			//가격
				String author = rs.getString("author");			//저자
				String bookdescription = rs.getString("bookdescription");		//설명
				String publisher = rs.getString("publisher");		//출판사
				String category = rs.getString("category");		//분류
				long unitsInStock = rs.getLong("unitsInStock"); 		//재고개수
				String releaseDate = rs.getString("releaseDate"); 	//출판일(월/년)
				String bookcondition = rs.getString("bookcondition");		//신제품 or 구제품 or 리퍼브제품
				String filename = rs.getString("filename");        //이미지 파일명
				//int quantity = rs.getInt("quantity");              //장바구니에 담은 개수
				
				Book bk = new Book();
				bk.setBookId(bookId);
				bk.setBookname(bookname);
				bk.setUnitPrice(unitPrice);
				bk.setAuthor(author);
				bk.setBookdescription(bookdescription);
				bk.setPublisher(publisher);
				bk.setCategory(category);
				bk.setUnitsInStock(unitsInStock);
				bk.setReleaseDate(releaseDate);
				bk.setBookcondition(bookcondition);
				bk.setFilename(filename);
				//bk.setQuantity(quantity);
				
				listOfBooks.add(bk);
			}
		} catch (SQLException e) {e.printStackTrace();}
			
		
		
		return listOfBooks;
	}
	
	public Book getBookById(String bookId) 
	{
		Book bookById=null;
		
		for(int i=0; i<listOfBooks.size(); i++) {
			Book book=listOfBooks.get(i);
			if(book!=null && book.getBookId()!=null && book.getBookId().equals(bookId)) {
				bookById=book;
				break;
			}
		}
		
		return bookById;
		
		
	}
	
public void addBook(Book book) 
	{
		listOfBooks.add(book);
	}
	
	
}
