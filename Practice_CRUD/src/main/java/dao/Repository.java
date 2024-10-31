package dao;

import java.sql.*;

import dto.member;

public class Repository {
	
	//싱글톤 객체 생성
	private static Repository dao = new Repository();
	public static Repository getInstance() {
		return dao;
	}
	
	public Connection DBconn()  {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String database = "jdbc:mysql://localhost:3306/practice";
			String id = "root";
			String pw = "1234";
			conn = DriverManager.getConnection(database, id, pw);
			System.out.println("데이터 베이스 연결 성공");
		} catch (Exception e) {System.out.println("데이터 베이스 연결 실패");}
		
		return conn;
	}
	
	
	public void createId(member mb) {
		//DB연결
		Connection conn = DBconn();
		//SQL전송
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into people values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPw());
			pstmt.setInt(3, mb.getAge());
			pstmt.executeUpdate();
		} 
		catch (Exception e) {e.printStackTrace();}
		finally 
		{
				try {
					if(pstmt!=null)
					pstmt.close();
					if(conn!=null)
						conn.close();
				} 
				catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	
}
