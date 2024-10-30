package dao;

import java.sql.*;

public class Repository {
	
	//싱글톤 객체 생성
	private static Repository dao = new Repository();
	public static Repository getInstance() {
		return dao;
	}
	
	public Connection DBconn() throws Exception {
		//jdbc 드라이버 로딩
		Class.forName("com.mysql.jdbc.Driver");
		
		//Connection 객체 생성
		Connection conn = null;
		String database = "jdbc:mysql:/localhost:3306/people";
		String root = "root";
		String password = "1234";
		conn = DriverManager.getConnection(database, root, password);
		
		return conn;
	}
	
	
	public void createId() {
		
	}
	
	
}
