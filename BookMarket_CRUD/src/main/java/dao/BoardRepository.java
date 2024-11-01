package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Board;

public class BoardRepository {
	//싱글톤
	private static BoardRepository br = new BoardRepository();
	private BoardRepository () {}
	public static BoardRepository getInstance() { return br; }
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection conn = null;
	
public Connection DBconn() {
		// DB 연결
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
	
	
	//행의 갯수를 리턴함
	public int getTotalCount() {
		int count = 0;
		//DB연결
		conn = DBconn();
		//SQL전송
		try {
			String sql = "select count(*) from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//ResultSet
			if(rs.next()) {
				// 컬러명이아니라 순서도 상관없다.
				count = rs.getInt(1);
			}
		} 
		catch (Exception e) {e.printStackTrace();}
		
		return count;
	}
	
	
	
	//Create
	public void create(Board bd) 
	{
		System.out.println("리파지토리의 create() 실행");
		//DB연결
		conn = DBconn();
		//쿼리전송
		String sql = "insert into board(id, name, subject, content, regist_day, hit, ip) values(?,?,?,?,?,?,?)";
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bd.getId());
			pstmt.setString(2, bd.getName());
			pstmt.setString(3, bd.getSubject());
			pstmt.setString(4, bd.getContent());
			pstmt.setTimestamp(5, bd.getRegist_day());
			pstmt.setInt(6, bd.getHit());
			pstmt.setString(7, bd.getIp());
			pstmt.executeUpdate();
			//ResultSet 없음
		} 
		catch (SQLException e) {e.printStackTrace();}
			try 
			{
				if(pstmt!=null)
				pstmt.close();
				if(conn!=null)
					conn.close();
			} 
			catch (SQLException e) {e.printStackTrace();}
	}
	//Read All
	public ArrayList<Board> getAllBoard() {
		System.out.println("2.Board 리파지토리의 getAllBoard() 실행");
		ArrayList<Board> arr = new ArrayList<Board>();
		
		//DB연결
		Connection conn = DBconn();
		//SQL 전송
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try 
		{
			String sql = "select * from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//후처리
			while(rs.next())
			{
				Board bd = new Board();
				bd.setNum(rs.getInt("num"));
				bd.setId(rs.getString("id"));
				bd.setName(rs.getString("name"));
				bd.setSubject(rs.getString("subject"));
				bd.setContent(rs.getString("content"));
				bd.setRegist_day(rs.getTimestamp("regist_day"));
				bd.setHit(rs.getInt("hit"));
				bd.setIp(rs.getString("ip"));
				
				arr.add(bd);
			}
		} 
		catch (Exception e) {e.printStackTrace();}
		
		
		
		
		return arr;
	}
	
	//Read One
	
	
	//Update
	
	//Delete
	
	
}
