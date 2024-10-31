package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import dto.Member;

public class MemberRepository 
{
	private MemberRepository() {}
	//싱글톤
	private static MemberRepository mr = new MemberRepository();
	public static MemberRepository getInstance() 
	{  //Getter로 만들면됨
		return mr;
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
	
	//Create
	public void create(Member mb) 
	{
		System.out.println("4.리파지토리의 create() 실행");
		//1.DB연결
		Connection conn = DBconn();
		//2.SQL전송
		PreparedStatement pstmt = null;
		String sql = "insert into Member values(?,?,?,?,?,?,?,?,?)";
		
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPassword());
			pstmt.setString(3, mb.getName());
			pstmt.setString(4, mb.getGendar());
			pstmt.setString(5, mb.getBirth());
			pstmt.setString(6, mb.getMail());
			pstmt.setString(7, mb.getPhone());
			pstmt.setString(8, mb.getAddress());
			pstmt.setTimestamp(9, mb.getRegist_day());
			pstmt.executeUpdate();
		} 
		catch (SQLException e) {e.printStackTrace();}
		finally 
		{
				try 
				{
					if(pstmt!=null) {pstmt.close();}
					if(conn!=null) {conn.close();}
				} 
				catch (SQLException e) {e.printStackTrace();}
		}
		
		//3.ResultSet 처리 없음
	}
	
	
	//Read
	public Member getUser(String id, String password) 
	{	
		System.out.println("4.리파지토리의 getUser() 실행");
		Member returnData = null;
		//DB 연결
		Connection conn = DBconn();
		//SQL 전송
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "Select * from Member where id=? and password=?";
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			//ResultSet반환 --> DTO 1개
			rs = pstmt.executeQuery();
			if(rs.next()) 
			{		
				returnData = new Member();
				returnData.setId(rs.getString("id"));
				returnData.setPassword(rs.getString("password"));
				returnData.setName(rs.getString("name"));
				returnData.setGendar(rs.getString("gender"));
				returnData.setBirth(rs.getString("birth"));
				returnData.setMail(rs.getString("mail"));
				returnData.setPhone(rs.getString("phone"));
				returnData.setAddress(rs.getString("address"));
				returnData.setRegist_day(rs.getTimestamp("regist_day"));
			}		
		} 
		catch (SQLException e) {e.printStackTrace();}
		try
		{
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(conn!=null) {conn.close();}
		}
		catch (SQLException e) {e.printStackTrace();}
		return returnData;
	}
	
	
	//Update
	
	//Delete
	
}
