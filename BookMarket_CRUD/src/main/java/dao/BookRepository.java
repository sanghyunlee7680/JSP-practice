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
	{	System.out.println("2:BookRepository 객체를 전달하기위한 getInstance실행");
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
	private BookRepository(){}
	
	// 전체 책DTO를 ArrayList에 묶어서 전송
	public ArrayList<Book> getAllBooks()
	{	System.out.println("3:리파지토리 getAllBooks 입장");
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
			// 후처리
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
				String filename = rs.getString("fileName");        //이미지 파일명
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
	
	//하나의 책DTO를 삽입한다
	public void addBook(Book book) {
		System.out.println("4.dao의 addBook함수 실행");
		//데이터베이스연결
		Connection conn = DBconn();
		//SQL전송
		PreparedStatement pstmt=null;
		
		String sql = "insert into book values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookId()); 
			pstmt.setString(2, book.getBookname());
			pstmt.setInt(3, book.getUnitPrice());
			pstmt.setString(4, book.getAuthor());
			pstmt.setString(5, book.getBookdescription());
			pstmt.setString(6, book.getPublisher());
			pstmt.setString(7, book.getCategory());
			pstmt.setLong(8, book.getUnitsInStock());
			pstmt.setString(9, book.getReleaseDate());
			pstmt.setString(10, book.getBookcondition());
			pstmt.setString(11, book.getFilename());
			pstmt.executeUpdate();
		} 
		catch (Exception e){e.printStackTrace();}
		finally 
		{
				try 
				{
					if(pstmt!=null)
						pstmt.close();
					if(conn!=null)
						conn.close();
				} 
				catch (Exception e) {e.printStackTrace();}
		}
	}
	
	//하나의 책DTO를 리턴한다
	public Book getOneBook(String bookId) {
		System.out.println("2.dao의 getOneBook()메소드 실행");
		//bk가 try안에 있어서 따로 변수 생성하고 변수로 리턴함
		Book oneBook = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//데이터 베이스 연결
		Connection conn = DBconn();
		//쿼리전송
		String sql = "select * from book where bookid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookId);
			rs = pstmt.executeQuery();
			//ResultSet을 객체로 전환
			
			if(rs.next()) {
				//데이터베이스의 id에 맞는 정보(dto)를 가져옴, 컬럼값을 변수처리
				String dbbookId = rs.getString("bookId");						//도서 ID
				String bookname = rs.getString("bookname");						//도서명
				int unitPrice = rs.getInt("unitPrice"); 						//가격
				String author = rs.getString("author");							//저자
				String bookdescription = rs.getString("bookdescription");		//설명
				String publisher = rs.getString("publisher");					//출판사
				String category = rs.getString("category");						//분류
				long unitsInStock = rs.getLong("unitsInStock"); 				//재고개수
				String releaseDate = rs.getString("releaseDate"); 				//출판일(월/년)
				String bookcondition = rs.getString("bookcondition");			//신제품 or 구제품 or 리퍼브제품
				String filename = rs.getString("fileName");        				//이미지 파일명
				
				//데이터 베이스에서 가져온 정보를 dto에 묶어서 담음
				Book bk = new Book();
				bk.setBookId(dbbookId);
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
				
				oneBook = bk;
			}
		} catch (SQLException e) {e.printStackTrace();}
		
		
		return oneBook;
	}
	
	
	//하나의 책DTO를 삭제한다
	public void delBook(String bookId) {
		System.out.println("2.delBook() 실행");
		//DB연결
		Connection conn = DBconn();
		PreparedStatement pstmt = null;
		//SQL 실행
		String sql = "delete from book where bookId=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookId);
			pstmt.executeUpdate();
		} catch (Exception e) {e.printStackTrace();}
	}
	
	//하나의 책DTO를 수정한다
	public void updateBook(Book book) {
		System.out.println("5.updateBook()메소드 실행");
		//DB연결
		Connection conn = DBconn();
		//SQL전송
		PreparedStatement pstmt = null;
		String sql = null;
		
		try 
		{
			if(book.getFilename()!=null) 
			{
			    sql = "UPDATE book SET bookname=?, unitPrice=?, author=?, bookdescription=?, publisher=?, category=?, unitsInStock=?, releaseDate=?, bookcondition=?, fileName=? WHERE bookid=?";   
				pstmt = conn.prepareStatement(sql);
			    pstmt.setString(1, book.getBookname());
			    pstmt.setInt(2, book.getUnitPrice());
			    pstmt.setString(3, book.getAuthor());
			    pstmt.setString(4, book.getBookdescription());
			    pstmt.setString(5, book.getPublisher());
			    pstmt.setString(6, book.getCategory());
			    pstmt.setLong(7, book.getUnitsInStock());
			    pstmt.setString(8, book.getReleaseDate());      
			    pstmt.setString(9, book.getBookcondition());   
			    pstmt.setString(10, book.getFilename());   
			    pstmt.setString(11, book.getBookId());   
			    pstmt.executeUpdate();
			}
			else
			{
				sql = "UPDATE book SET bookname=?, unitPrice=?, author=?, bookdescription=?, publisher=?, category=?, unitsInStock=?, releaseDate=?, bookcondition=? WHERE bookid=?";   
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, book.getBookname());
			    pstmt.setInt(2, book.getUnitPrice());
			    pstmt.setString(3, book.getAuthor());
			    pstmt.setString(4, book.getBookdescription());
			    pstmt.setString(5, book.getPublisher());
			    pstmt.setString(6, book.getCategory());
			    pstmt.setLong(7, book.getUnitsInStock());
			    pstmt.setString(8, book.getReleaseDate());      
			    pstmt.setString(9, book.getBookcondition());    
			    pstmt.setString(10, book.getBookId());
			}
		} 
		catch (SQLException e) {e.printStackTrace();}
	}
}
	

