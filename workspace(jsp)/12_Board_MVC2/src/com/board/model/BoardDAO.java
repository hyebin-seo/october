package com.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class BoardDAO {

	Connection con = null;              // DB 연결하는 객체.
	PreparedStatement pstmt = null;     // DB에 SQL문을 전송하는 객체.
	ResultSet rs = null;                // SQL문을 실행 후 결과 값을 가지고 있는 객체.
	
	String sql = null;                  // 쿼리문을 저장할 객체.

	// 싱글톤 방식으로 BoardDAO 객체를 만들자.
	// 1단계 : 싱글톤 방식으로 객체를 만들기 위해서는 우선적으로 
	//       기본생성자의 접근제어자를  private 으로 선언을 해야 함.
	// 2단계 : 정적 멤버로 선언을 해야 함 - static 으로 선언을 한다는 의미.
	private static BoardDAO instance = null;
	
	// 3단계 : 외부에서 객체 생성을 하지 못하게 접근을 제어 - private 기본 생성자를 만듬.
	private BoardDAO() { }
	
	// 4단계 : 기본 생성자 대신에 싱긑턴 객체를 return을 해 주는 getInstance()
	//        메서드를 만들어서 여기에 접근하게 하는 방법
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}  // getInstance() 메서드 end
	
	// DB 연동하는 작업을 진행하는 메서드 - DBCP방식으로 연결 진행
	public void openConn() {
		
		
		try {
			// 1단계 : JNDI 서버 객체 생성.
			Context ctx = new InitialContext();
			
			// 2단계 : lookup() 메서드를 이용하여 매칭되는 커넥션을 찾는다.
			DataSource ds = 
				(DataSource)ctx.lookup("java:comp/env/jdbc/myoracle");
			
			// 3단계 : DataSource 객체를 이용하여 커넥션 객체를 하나 가져온다.
			con = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}  // openConn() 메서드 end
	
	
	// board 테이블의 전체 리스트를 조회하는 메서드
	public List<BoardDTO> getBoardList() {
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();

		try {
			
			openConn();
			
			sql = "select * from board "
					+ " order by board_no desc";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_regdate(rs.getString("board_regdate"));
				
				list.add(dto);
				
			}
			
			// open 객체 닫기
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}  // getBoardList() 메서드 end
	
	
	
	// board 테이블에 게시굴을 저장하는 메서드
	public int insertBoard(BoardDTO dto) {
		int result = 0, count = 0;
		
		openConn();
		
		try {
			// 자동으로 커밋되는 것을 방지하는 기능
			con.setAutoCommit(false);
			
			sql = "select max(board_no) from board";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1) + 1;
			}
			
			sql = "insert into board "
					+ " values(?, ?, ?, ?, ?, default, sysdate)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, count);
			pstmt.setString(2, dto.getBoard_writer());
			pstmt.setString(3, dto.getBoard_title());
			pstmt.setString(4, dto.getBoard_cont());
			pstmt.setString(5, dto.getBoard_pwd());
			
			result = pstmt.executeUpdate();
			con.commit();  // DB에 완전히 저장하는 메서드
			
			// open 객체 닫기
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				// 처리 도중에 문제가 발생한 경우
				// 이전 상태로 되돌아가야 함.
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return result;
	}  // insertBoard() 메서드 end
	
	// 조회수 증가
	public void boardHit(int board_no) {
		openConn();
		
		sql = "update board set board_hit = board_hit + 1 where board_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, board_no);
			pstmt.executeUpdate();
			
			pstmt.close(); con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// 글 번호에 해당하는 글 상세내역 조회
	public BoardDTO boardCont(int board_no) {
		BoardDTO dto = new BoardDTO();
		
		try {
			openConn();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, board_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_regdate(rs.getString("board_regdate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	// 글수정
	public int updateBoard(BoardDTO dto) {
		int result = 0;
		
		
		
		try {
			openConn();
			
			sql = "update board set board_title = ?, board_cont = ? where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getBoard_title());
			pstmt.setString(2, dto.getBoard_cont());
			pstmt.setInt(3, dto.getBoard_no());
			
			result = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public int deleteBoard(int no, String pwd) {
		int result = 0;

		try {
			openConn();
			sql = "select * from board where board_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(pwd.equals(rs.getString("board_pwd"))) {
					sql = "delete from board where board no = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, no);
					result = pstmt.executeUpdate();
				} else { // 비밀번호 틀린 경우
					result = -1;
				}
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<BoardDTO> searchBoard(String field, String name) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		openConn();

		try {
			if(field.equals("title")) {
				sql = "select * from board where board_title like ?";
			} else if(field.equals("content")) {
				sql = "select * from board where board_content like ?";
			} else if(field.equals("title_content")) {
				sql = "select * from board where board_title like ? OR board_cont like ?";
			} else if(field.equals("writer")) {
				sql = "select * from board where board_writer like ?";
			}
			
			pstmt = con.prepareStatement(sql);
			
			if(field.equals("title_content")) {
				pstmt.setString(1, "%"+name+"%");
				pstmt.setString(2, "%"+name+"%");
			} else {
				pstmt.setString(1, "%"+name+"%");
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_regdate(rs.getString("board_regdate"));
				
				list.add(dto);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	
	
	
}
