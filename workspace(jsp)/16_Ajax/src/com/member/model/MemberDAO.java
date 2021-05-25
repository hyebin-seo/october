package com.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class MemberDAO {

	Connection con = null;              
	PreparedStatement pstmt = null;    
	ResultSet rs = null;                
	
	String sql = null;                

	private static MemberDAO instance = null;
	
	private MemberDAO() { }
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	} 
	
	public void openConn() {
		
		
		try {
			Context ctx = new InitialContext();
			
			DataSource ds = 
				(DataSource)ctx.lookup("java:comp/env/jdbc/myoracle");
			
			con = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}  
	
	public int checkMemberId(String id) {
		int result = 0;
		
		
		try {
			openConn();
			
			sql = "Select * from member10 where memid = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
