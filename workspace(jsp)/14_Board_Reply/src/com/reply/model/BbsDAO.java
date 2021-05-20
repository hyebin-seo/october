package com.reply.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BbsDAO {
	Connection con = null;              
	PreparedStatement pstmt = null;     
	ResultSet rs = null;               
	
	String sql = null;                 

	private static BbsDAO instance = null;
	
	private BbsDAO() { }
	
	public static BbsDAO getInstance() {
		if(instance == null) {
			instance = new BbsDAO();
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
	
	public void closeConn(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getListCount() {
		int count = 0;
		
		try {
			
			openConn();
			
			sql = "select count(*) from jsp_bbs";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return count;
	}
	
	public List<BbsDTO> getBbsList(int page, int rowsize) {
		
		List<BbsDTO> list = new ArrayList<BbsDTO>();
		
		int startNo = (page * rowsize) - (rowsize - 1);
		int endNo = (page * rowsize);

		try {
			
			openConn();
			
			sql = "select * from(SELECT b.*, ROW_NUMBER() "
					+ "OVER(ORDER BY board_no DESC) rn FROM jsp_bbs b) where rn >= ? and rn <= ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BbsDTO dto = new BbsDTO();
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_date(rs.getString("board_date"));
				dto.setBoard_group(rs.getInt("board_group"));
				dto.setBoard_step(rs.getInt("board_step"));
				dto.setBoard_indent(rs.getInt("board_indent"));
				
				list.add(dto);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return list;
	}
	
	public int insertBbs(BbsDTO dto) {
		int result = 0, count = 0;
		
		openConn();
		
		try {
			con.setAutoCommit(false);
			
			sql = "select max(board_no) from jsp_bbs";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1) + 1;
			}
			
			sql = "insert into jsp_bbs "
					+ " values(?, ?, ?, ?, ?, default, sysdate,?,0,0)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, count);
			pstmt.setString(2, dto.getBoard_writer());
			pstmt.setString(3, dto.getBoard_title());
			pstmt.setString(4, dto.getBoard_cont());
			pstmt.setString(5, dto.getBoard_pwd());
			pstmt.setInt(6, count);
			
			result = pstmt.executeUpdate();
			con.commit();  
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
	}
	
	public void bbsHit(int no) {
		
		try {
			
			openConn();
			
			sql = "update jsp_bbs set "
					+ " board_hit = board_hit + 1 "
					+ " where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
	} 
	
	public BbsDTO bbsCont(int no) {
		
		BbsDTO dto = new BbsDTO();
		
		try {
			
			openConn();
			
			sql = "select * from jsp_bbs "
					+ " where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_date(rs.getString("board_date"));
				dto.setBoard_group(rs.getInt("board_group"));
				dto.setBoard_step(rs.getInt("board_step"));
				dto.setBoard_indent(rs.getInt("board_indent"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return dto;
	}
	
	public int updateBoard(BbsDTO dto, String pwd) {
		
		int result = 0;
		
		try {
			
			openConn();
			
			sql = "select * from jsp_bbs where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getBoard_no());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(pwd.equals(rs.getString("board_pwd"))) {
					sql = "update jsp_bbs set board_title = ?, "
							+ " board_cont = ? where board_no = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getBoard_title());
					pstmt.setString(2, dto.getBoard_cont());
					pstmt.setInt(3, dto.getBoard_no());
					
					result = pstmt.executeUpdate();
				} else {
					result = -1;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
	} 
	
	
	public int deleteBoard(int no, String pwd) {
		
		int result = 0;
		
		try {
			openConn();
			
			sql = "select * from jsp_bbs where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(pwd.equals(rs.getString("board_pwd"))) {
					sql = "delete from jsp_bbs where board_no = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, no);
					
					result = pstmt.executeUpdate();
				}else {
					result = -1;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
	}
	
	public void updateNo(int no) {
		
		try {
			openConn();
			sql = "update jsp_bbs set board_no = board_no - 1 where board_no > ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		
	}
}
