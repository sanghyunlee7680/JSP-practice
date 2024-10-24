package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import dto.member_dto;

public class member_repository {
	//1개만 존재해야디므로 싱글톤으로 작성
	private static member_repository mr = new member_repository();
	public static member_repository getInstance() {
		return mr;
	}
	
	//Create
	public void member_create(member_dto dto) {
		try {
			// Step 1 : JDBC 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			// Step 2 : Connection 객체 생성  
			// 확인사항 1. 데이터베이스의 생성여부 2. WEB-INF폴더에 라이브러리(lib) 확인
			Connection conn = null;
			String database ="jdbc:mysql://localhost:3306/login_crud";
			String id ="root";
			String password ="1234";
			conn = DriverManager.getConnection(database,id,password);
			System.out.println("데이터 베이스 연결 완료");
		} catch (Exception e) {System.out.println("데이터 베이스 연결 오류");}
		
		// Step 3 : SQ 전송객체 생성 및 전송
		
		// Step 4 : 리턴이 있다면 ResultSet 객체에 담기 - CUD는 해당없음
	}
	//Read
	
	//Update
	public void member_update() {
		
	}
	//Delete
	public void member_delete() {
		
	}
}
