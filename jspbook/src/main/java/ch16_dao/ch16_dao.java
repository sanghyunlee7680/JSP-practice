package ch16_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ch16_dto.ch16_dto;



public class ch16_dao {
	private ch16_dao () {}
	//싱글톤방식 항상 존재해야한다.
	private static ch16_dao dao = new ch16_dao();
	public static ch16_dao getInstance() {
		return dao;
	}
	
	public Connection DBconn() {
		Connection conn = null;
		try {
			//DB연결
			Class.forName("com.mysql.jdbc.Driver");
			String db = "jdbc:mysql://localhost:3306/jspbook";
			String id = "root";
			String pw = "1234";
			conn = DriverManager.getConnection(db,id,pw);
			System.out.println("데이터베이스 연결완료");
		} catch (Exception e) {e.printStackTrace();}
		return conn;		
	}
	
	public void createPlayer(ch16_dto dto) {
		// Create 
		// 1.DB생성
		// 2.Query 전송 및 실행
		Statement stmt = null;
		Connection conn = null;
		try {
			conn = DBconn();
			stmt = conn.createStatement();
			String userId = dto.getId();
			String userPw = dto.getPw();
			String userName = dto.getName();
			String sql = "insert into player values('"+userId+"','"+userPw+"','"+userName+"')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {e.printStackTrace();}
		finally {
				try {
					if (stmt!=null)
					stmt.close();
					if (conn!=null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
	
	public void p_createPlayer(ch16_dto dto) {
		//Create
		Connection conn = DBconn();
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into player values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.executeUpdate();
			System.out.println("테이블 삽입이 성공했씁니다.");
		} catch (SQLException e) {e.printStackTrace();}
		finally {
				try {
					if(pstmt!=null)
						pstmt.close();
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {e.printStackTrace();}
		}
		
	}
	public ArrayList<ch16_dto> getAllplayer(){
		//전체 테이블 조회
		ArrayList<ch16_dto> arr = new ArrayList<ch16_dto>(); 
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = DBconn();
			String sql = "select * from player";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				
				ch16_dto dto = new ch16_dto();
				dto.setId(id);
				dto.setPw(pw);
				dto.setName(name);
				
				arr.add(dto);
			}
		} catch (Exception e) {e.printStackTrace();}
		return arr;
	}
	
	public ch16_dto getOneplayer(String id) {
		// 검색해서 조회하기
		ch16_dto dto = new ch16_dto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBconn();
			String sql = "select * from player where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				String userId = rs.getString("id");
				String userPw = rs.getString("pw");
				String userName = rs.getString("name");
				
				dto.setId(userId);
				dto.setPw(userPw);
				dto.setName(userName);
			}
		} catch (SQLException e) {e.printStackTrace();}
		return dto;
	}
	public void updatePlayer(ch16_dto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println(dto.getPw());
		try {
			System.out.println("업데이트 진입");
			conn = DBconn();
			String sql = "update player set pw=?, name=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getId());
			pstmt.executeUpdate();
			System.out.println("player 테이블을 수정했습니다.");
		} catch (SQLException e) {e.printStackTrace();}
	}
}
