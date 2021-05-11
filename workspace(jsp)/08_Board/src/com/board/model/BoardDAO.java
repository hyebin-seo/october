package com.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	Connection con = null;              
	PreparedStatement pstmt = null;     
	ResultSet rs = null;               
	
	String sql = null;                  

	private static BoardDAO instance = null;
	
	private BoardDAO() { }
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	} 
	
	public void openConn() {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "web";
		String password = "1234";

		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardDTO> getBoardList() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		openConn();
		
		sql = "select * from board order by board_no desc";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("Board_title"));
				dto.setBoard_cont(rs.getString("Board_cont"));
				dto.setBoard_pwd(rs.getString("Board_pwd"));
				dto.setBoard_hit(rs.getInt("Board_hit"));
				dto.setBoard_regdate(rs.getString("Board_regdate"));
				
				list.add(dto);	
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public int insertBoard(BoardDTO dto) {
		int result=0;
		
		openConn();

		try {
			sql = "insert into board values(board_seq.nextval, ?,?,?,?, default, sysdate)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoard_writer());
			pstmt.setString(2, dto.getBoard_title());
			pstmt.setString(3, dto.getBoard_cont());
			pstmt.setString(4, dto.getBoard_pwd());
			
			result = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void boardHit(int board_no) {
		
		openConn();

		try {
			sql = "update board set board_hit = board_hit+1 where board_no= ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public BoardDTO boardCont(int board_no) {
		BoardDTO dto = new BoardDTO();
		
		openConn();
		
		try {
			sql = "select * from board where board_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("Board_title"));
				dto.setBoard_cont(rs.getString("Board_cont"));
				dto.setBoard_pwd(rs.getString("Board_pwd"));
				dto.setBoard_hit(rs.getInt("Board_hit"));
				dto.setBoard_regdate(rs.getString("Board_regdate"));
			}
			
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public int updateBoard(BoardDTO dto) {
		int result=0;
		
		openConn();

		try {
			sql = "select * from board where board_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBoard_no());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(dto.getBoard_pwd().equals(rs.getString("board_pwd"))) {
					sql = "update board "
							+ "set board_title=?, board_cont=?"
							+ "where board_no=?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, dto.getBoard_title());
					pstmt.setString(2, dto.getBoard_cont());
					pstmt.setInt(3, dto.getBoard_no());
					
					result = pstmt.executeUpdate();
				} else { //비밀번호 틀린 경우
					result = -1;
				}
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int deleteBoard(int board_no, String pwd) {
		int result = 0;
		
		openConn();

		try {
			sql = "select * from board where board_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(pwd.equals(rs.getString("board_pwd"))) {
					sql = "delete from board where board_no=?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, board_no);
					
					result = pstmt.executeUpdate();
				} else { //비밀번호 틀린 경우
					result = -1;
				}
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<BoardDTO> searchBoard(String find_field, String find_name) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		openConn();
		
		if(find_field.equals("title")) { //제목검색
			sql="select * from board where board_title like ? order by board_no desc";
		} else if(find_field.equals("content")) {
			sql="select * from board where board_cont like ? order by board_no desc";
		} else if(find_field.equals("title_content")) {
			sql="select * from board "
					+ "where board_title like ? OR board_cont like ? order by board_no desc";
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+find_name+"%");
			if(find_field.equals("title_content")) {
				pstmt.setString(2, "%"+find_name+"%");
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("Board_title"));
				dto.setBoard_cont(rs.getString("Board_cont"));
				dto.setBoard_pwd(rs.getString("Board_pwd"));
				dto.setBoard_hit(rs.getInt("Board_hit"));
				dto.setBoard_regdate(rs.getString("Board_regdate"));
				
				list.add(dto);	
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
