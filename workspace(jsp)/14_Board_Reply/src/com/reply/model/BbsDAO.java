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

	Connection con = null;              // DB 연결하는 객체.
	PreparedStatement pstmt = null;     // DB에 SQL문을 전송하는 객체.
	ResultSet rs = null;                // SQL문을 실행 후 결과 값을 가지고 있는 객체.
	
	String sql = null;                  // 쿼리문을 저장할 객체.

	// 싱글톤 방식으로 BoardDAO 객체를 만들자.
	// 1단계 : 싱글톤 방식으로 객체를 만들기 위해서는 우선적으로 
	//       기본생성자의 접근제어자를  private 으로 선언을 해야 함.
	// 2단계 : 정적 멤버로 선언을 해야 함 - static 으로 선언을 한다는 의미.
	private static BbsDAO instance = null;
	
	// 3단계 : 외부에서 객체 생성을 하지 못하게 접근을 제어 - private 기본 생성자를 만듬.
	private BbsDAO() { }
	
	// 4단계 : 기본 생성자 대신에 싱긑턴 객체를 return을 해 주는 getInstance()
	//        메서드를 만들어서 여기에 접근하게 하는 방법
	public static BbsDAO getInstance() {
		if(instance == null) {
			instance = new BbsDAO();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}  // openConn() 메서드 end
	
	// DB에 연결된 객체를 종료하는 메서드
	public void closeConn(ResultSet rs,
			PreparedStatement pstmt, Connection con)  {
		
		
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}  // closeConn() 메서드 end
	
	
	// jsp_bbs 테이블의 전체 게시물의 수를 조회하는 메서드
	public int getListCount() {
		int count = 0;
		
		try {
			
			openConn();
			
			sql = "select count(*) from jsp_bbs";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return count;
	}  // getListCount() 메서드 end
	
	
	// jsp_bbs 테이블의 페이지에 보여질 게시물의 수만큼 게시물을 조회하는 메서드
	public List<BbsDTO> getBbsList(int page, int rowsize) {
		List<BbsDTO> list = new ArrayList<BbsDTO>();
		
		// 해당 페이지에서의 시작 번호
		int startNo = (page * rowsize) - (rowsize - 1);
		
		// 해당 페이지에서의 마지막 번호
		int endNo = (page * rowsize);
		
		
		try {
			openConn();
			
			sql = "select * from "
					+ " (select row_number() "
					+ " over(order by board_group desc, board_step) rnum, "
					+ " b.* from jsp_bbs b) "
					+ " where rnum >= ? and rnum <= ?";
			
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return list;
	}  // getBbsList() 메서드 end
	
	
	// jsp_bbs 테이블에 게시글을 추가하는 메서드
	public int insertBbs(BbsDTO dto) {
		int result = 0, count = 0;
		
		try {
			openConn();
			sql = "select count(*) from jsp_bbs";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1) + 1;
			}
			
			sql = "insert into jsp_bbs values("
					+ "?,?,?,?,?,default,sysdate,?,0,0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setString(2, dto.getBoard_writer());
			pstmt.setString(3, dto.getBoard_title());
			pstmt.setString(4, dto.getBoard_cont());
			pstmt.setString(5, dto.getBoard_pwd());
			pstmt.setInt(6, count);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
	}  // insertBbs() 메서드 end
	
	
	// jsp_bbs 테이빌의 게시물 조회수를 증가시키는 메서드
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
	}  // bbsHit() 메서드 end
	
	
	// jsp_bbs 테이블의 게시물 번호에 해당하는 상세내역을 조회하는 메서드
	public BbsDTO getBbsCont(int no) {
		BbsDTO dto = new BbsDTO();
		
		
		try {
			openConn();
			
			sql = "select * from jsp_bbs "
					+ " where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return dto;
	}  // getBbsCont() 메서드 end
	
	
	// jsp_bbs 테이블에 글번호에 해당하는 게시글을 수정하는 메서드
	public int updateBbs(BbsDTO dto) {
		int result = 0;
		
		try {
			
			openConn();
			
			sql = "update jsp_bbs set "
					+ " board_title = ?, board_cont = ? "
					+ " where board_no = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getBoard_title());
			pstmt.setString(2, dto.getBoard_cont());
			pstmt.setInt(3, dto.getBoard_no());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
	}  // updateBbs() 메서드 end
	
	
	// jsp_bbs 테이블에서 게시글을 삭제하는 메서드
	public int deleteBBs(BbsDTO dto) {
		int result = 0, count = 0;
		
		try {
			
			openConn();
			
			sql = "select count(*) from jsp_bbs "
					+ " where board_no > ? and "
					+ " board_group = ? and "
					+ " board_step > ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getBoard_no());
			pstmt.setInt(2, dto.getBoard_group());
			pstmt.setInt(3, dto.getBoard_step());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
			if(count > 0) {  // 답글이 있는 경우
				result = -2;
			}else {
				sql = "select * from jsp_bbs "
						+ " where board_no = ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, dto.getBoard_no());
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					if(dto.getBoard_pwd().equals(rs.getString("board_pwd"))) {
						sql = "delete from jsp_bbs "
								+ " where board_no = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, dto.getBoard_no());
						
						result = pstmt.executeUpdate();
						
					}else {  // 비밀번호가 틀린 경우
						result = -1;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
	}  // deleteBBs() 메서드 end
	
	
	// jsp_bbs 테이블에서 중간에 삭제된 글이 있는 경우 글번호를 다시 정비하는 메서드
	public void updateNo(int no) {
		
		
		try {
			openConn();
			
			sql = "update jsp_bbs "
					+ " set board_no = board_no - 1,"
					+ " board_group = board_group - 1 "
					+ " where board_no > ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
	}  // updateNo() 메서드 end
	
	
	// jsp_bbs 테이블 게시판 답변 글의 step을 하나 증가시키는 메서드
	public void replyUpdate(int group, int step) {
		
		
		try {
			openConn();
			
			sql = "update jsp_bbs set "
					+ " board_step = board_step + 1 "
					+ " where board_group = ? and board_step > ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, group);
			pstmt.setInt(2, step);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
	}  // replyUpdate() 메서드 end
	
	
	
	// jsp_bbs 테이블의 게시글 원글에 답변글을 추가하는 메서드
	public int replyBbs(BbsDTO dto) {
		int result = 0, count = 0;
		
		
		try {
			
			openConn();
			
			sql = "select count(*) from jsp_bbs";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1) + 1;
			}
			
			sql = "insert into jsp_bbs "
					+ " values(?,?,?,?,?,default,sysdate,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, count);
			pstmt.setString(2, dto.getBoard_writer());
			pstmt.setString(3, dto.getBoard_title());
			pstmt.setString(4, dto.getBoard_cont());
			pstmt.setString(5, dto.getBoard_pwd());
			pstmt.setInt(6, dto.getBoard_group());
			pstmt.setInt(7, dto.getBoard_step() + 1);
			pstmt.setInt(8, dto.getBoard_indent() + 1);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		
		return result;
	}  // replyBbs() 메서드 end
	
	
	
	
	
	
	
}
