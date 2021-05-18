package com.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
	
	public int getListCount() {
		int count = 0;
		
		try {
			
			openConn();
			
			sql = "select count(*) from board";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt(1);
			}
			
			// open 객체 닫기
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	// board 테이블의 전체 리스트를 조회하는 메서드
	public List<BoardDTO> getBoardList(int page, int rowsize) {
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		int startNo = (page * rowsize) - (rowsize - 1);
		int endNo = (page * rowsize);

		try {
			
			openConn();
			
			sql = "select * from(SELECT b.*, ROW_NUMBER() OVER(ORDER BY board_no DESC) rn FROM board b) where rn >= ? and rn <= ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			
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
			e.printStackTrace();
			
			try {
				// 처리 도중에 문제가 발생한 경우
				// 이전 상태로 되돌아가야 함.
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return result;
	}  // insertBoard() 메서드 end
	
	public void boardHit(int board_no) {
		
		try {
			
			openConn();
			
			sql = "update board set "
					+ " board_hit = board_hit + 1 "
					+ " where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, board_no);
			
			pstmt.executeUpdate();
			
			// open 객체 닫기
			pstmt.close(); con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}  // boardHit() 메서드 end
	
	
	// 글번호에 해당하는 글의 전체 내용을 조회하는 메서드
	public BoardDTO boardCont(int board_no) {
		
		BoardDTO dto = new BoardDTO();
		
		try {
			
			openConn();
			
			sql = "select * from board "
					+ " where board_no = ?";
			
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
			
			//open 객체 닫기
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}  // boardCont() 메서드 end
	
	
	// board 테이블의 글번호에 해당하는 게시글을 수정하는 메서드
	public int updateBoard(BoardDTO dto) {
		
		int result = 0;
		
		try {
			
			openConn();
			
			sql = "select * from board where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getBoard_no());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sql = "update board set board_title = ?, "
						+ " board_cont = ? where board_no = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getBoard_title());
				pstmt.setString(2, dto.getBoard_cont());
				pstmt.setInt(3, dto.getBoard_no());
				
				// 수정 성공 시에는 1(숫자값) 반환 
				result = pstmt.executeUpdate();
			}
			
			// open 객체 닫기
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}  // updateBoard() 메서드 end
	
	
	// board 테이블에서 글번호에 해당하는 게시글을 삭제하는 메서드
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
					sql = "delete from board where board_no = ?";
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, no);
					
					result = pstmt.executeUpdate();
				}else {
					result = -1;
				}
			}
			
			// open 객체 닫기
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}  // deleteBoard() 메서드 end
	
	
	// board 테이블에서 게시물을 검색하는 메서드
	public List<BoardDTO> searchBoardList
				(String field, String name, int page, int rowsize) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		//해당 페이지에서 시작 번호
		int startNo = (page * rowsize) - (rowsize - 1);
		
		//해당 페이지에서 마지막 번호
		int endNo = (page * rowsize);
		
		openConn();
		
		try {
			if( field.equals("title")) {
				// 제목으로 검색한 경우
				sql = "select * from "
						+ " (select row_number() "
						+ " over(order by board_no desc) rnum,"
						+ " b.* from board b "
						+ " where board_title like ?) "
						+ " where rnum >= ? and rnum <= ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+name+"%");
				pstmt.setInt(2, startNo);
				pstmt.setInt(3, endNo);
	
			} else if(field.equals("content")) {
				// 내용으로 검색한 경우
				sql = "select * from "
						+ " (select row_number() "
						+ " over(order by board_no desc) rnum,"
						+ " b.* from board b "
						+ " where board_cont like ?) "
						+ " where rnum >= ? and rnum <= ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+name+"%");
				pstmt.setInt(2, startNo);
				pstmt.setInt(3, endNo);
	
			} else if(field.equals("title_content")){
				// 제목+내용으로 검색한 경우
				sql = "select * from "
						+ " (select row_number() "
						+ " over(order by board_no desc) rnum,"
						+ " b.* from board b "
						+ " where board_title like ? or board_cont like ? ) "
						+ " where rnum >= ? and rnum <= ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+name+"%");
				pstmt.setString(2, "%"+name+"%");
				pstmt.setInt(3, startNo);
				pstmt.setInt(4, endNo);
				
			} else {
				//작성자 검색
				sql ="select * from "
						+ " (select row_number() "
						+ " over(order by board_no desc) rnum,"
						+ " b.* from board b "
						+ " where board_writer like ?) "
						+ " where rnum >= ? and rnum <= ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+name+"%");
				pstmt.setInt(2, startNo);
				pstmt.setInt(3, endNo);
	
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
		
			// open 객체 닫기
			rs.close(); pstmt.close(); con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public void boardInsert10() {
		
		int count = 0;
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
			
			for (int i = 1; i < 11; i++) {
				int temp_count = count + i;
				String temp_writer = "이름" + i;
				String temp_title = "제목" + i;
				String temp_cont = "내용" + i;
				String temp_pwd = "비밀번호";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, temp_count);
				pstmt.setString(2, temp_writer);
				pstmt.setString(3, temp_title);
				pstmt.setString(4, temp_cont);
				pstmt.setString(5, temp_pwd);
				
				pstmt.executeUpdate();
				con.commit();
			}
			  // DB에 완전히 저장하는 메서드
			
			// open 객체 닫기
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				// 처리 도중에 문제가 발생한 경우
				// 이전 상태로 되돌아가야 함.
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	//중간에 삭제된 게시글이 있는 경우 글 번호를 다시 적용시키는 메서드
	public void updateNo(int no) {
		
		try {
			openConn();
			sql = "update board set board_no = board_no - 1 where board_no > ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//board 테이블에서 검색어에 해당하는 게시물의 수를 조회하는 메서드
	public int searchListCount(String field, String name) {
		int count = 0;
		
		openConn();
		
		try {
			if(field.equals("title")) { //제목 검색
				sql = "select count(*) from board "
						+ " where board_title like ? "
						+ " order by board_no desc";
			} else if(field.equals("content")) { //내용 검색
				sql = "select count(*) from board "
						+ " where board_cont like ? "
						+ " order by board_no desc";
			} else if(field.equals("title_content")) { //제목+내용 검색
				sql = "select count(*) from board "
						+ " where board_cont like ? or board_title like ? "
						+ " order by board_no desc";
			} else if(field.equals("writer")) { //작성자 검색
				sql = "select count(*) from board "
						+ " where board_writer like ? "
						+ " order by board_no desc";
			}
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			
			if(field.equals("title_content")) {
				pstmt.setString(2, "%"+name+"%");
			}
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
			// open 객체 닫기
			rs.close(); pstmt.close(); con.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
}
