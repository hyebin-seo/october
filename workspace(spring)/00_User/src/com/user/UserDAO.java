package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO { //추상클래스
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private ConnectionMaker connectionMaker;
	
	public UserDAO() {
		
	}
	
	public UserDAO(ConnectionMaker connectionMaker) {
		this.connectionMaker = new AConnectionMaker();
	}
	
	//DB 연결 부분 호출 메서드
	//public abstract void openConn(); //추상메서드
	
	public void add(UserDTO dto) {
		
		try {
			connectionMaker.makeConnection();
			
			String sql = "insert into users values(?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPwd());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public UserDTO getUser(String id) {
		UserDTO dto = new UserDTO();
		
		try {
			connectionMaker.makeConnection();
			
			String sql = "select * from users where id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPwd(rs.getString("pwd"));
			}
			
			rs.close(); pstmt.close(); con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	
}
