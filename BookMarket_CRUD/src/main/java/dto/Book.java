package dto;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID=-4274700572038677000L;
	
	private String bookId;			//도서 ID
	private String bookname;			//도서명
	private int unitPrice; 			//가격
	private String author;			//저자
	private String bookdescription;		//설명
	private String publisher;		//출판사
	private String category;		//분류
	private long unitsInStock; 		//재고개수
	private String releaseDate; 	//출판일(월/년)
	private String bookcondition;		//신제품 or 구제품 or 리퍼브제품
	private String filename;        //이미지 파일명
	private int quantity; 			//장바구니에 담은 개수
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Book() {}
	public Book(String bookId, String bookname, Integer unitPrice) {
		this.bookId = bookId;
		this.bookname = bookname;
		this.unitPrice = unitPrice;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookdescription() {
		return bookdescription;
	}

	public void setBookdescription(String bookdescription) {
		this.bookdescription = bookdescription;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getBookcondition() {
		return bookcondition;
	}

	public void setBookcondition(String bookcondition) {
		this.bookcondition = bookcondition;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
