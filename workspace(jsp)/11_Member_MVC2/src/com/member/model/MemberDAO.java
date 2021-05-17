package com.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class MemberDAO {

	Connection con = null;              // DB 연결하는 객체.
	PreparedStatement pstmt = null;     // DB에 SQL문을 전송하는 객체.
	ResultSet rs = null;                // SQL문을 실행 후 결과 값을 가지고 있는 객체.
	
	String sql = null;                  // 쿼리문을 저장할 객체.

	// 싱글톤 방식으로 BoardDAO 객체를 만들자.
	// 1단계 : 싱글톤 방식으로 객체를 만들기 위해서는 우선적으로 
	//       기본생성자의 접근제어자를  private 으로 선언을 해야 함.
	// 2단계 : 정적 멤버로 선언을 해야 함 - static 으로 선언을 한다는 의미.
	private static MemberDAO instance = null;
	
	// 3단계 : 외부에서 객체 생성을 하지 못하게 접근을 제어 - private 기본 생성자를 만듬.
	private MemberDAO() { }
	
	// 4단계 : 기본 생성자 대신에 싱긑턴 객체를 return을 해 주는 getInstance()
	//        메서드를 만들어서 여기에 접근하게 하는 방법
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
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
	
	
	
	// member10  테이블에서 전체 리스트롤 조회하는 메서드
	public List<MemberDTO> getMemberList() {
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		
		try {
			
			// 커넥션 풀 방식으로 DB와 연동 진행
			openConn();
			
			sql = "select * from member10 "
					+ " order by num desc";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setNum(rs.getInt("num"));
				dto.setMemid(rs.getString("memid"));
				dto.setMemname(rs.getString("memname"));
				dto.setPwd(rs.getString("pwd"));
				dto.setAge(rs.getInt("age"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setJob(rs.getString("job"));
				dto.setAddr(rs.getString("addr"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
			}
			
			// open 객체 닫기
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}  // getMemberList() 메서드 end
	
	
	// member10 테이블에 회원의 정보를 저장하는 메서드
	public int insertMember(MemberDTO dto) {
		
		int result = 0;
		
		try {
			
			openConn();
			
			sql = "insert into member10 values"
					+ "(member10_seq.nextval,?,?,?,?,?,?,?,sysdate)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getMemid());
			
			pstmt.setString(2, dto.getMemname());
			
			pstmt.setString(3, dto.getPwd());
			
			pstmt.setInt(4, dto.getAge());
			
			pstmt.setInt(5, dto.getMileage());
			
			pstmt.setString(6, dto.getJob());
			
			pstmt.setString(7, dto.getAddr());
			
			result = pstmt.executeUpdate();
			
			// open 객체 닫기
			pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}  // insertMember() 메서드 end
	
	
	
	// 회원번호에 해당하는 회원의 정보를 조회하는 메서드
	public MemberDTO contentMember(int no) {
		
		MemberDTO dto = new MemberDTO();
		
		try {
			
			openConn();
			
			sql = "select * from member10 "
					+ " where num = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setMemid(rs.getString("memid"));
				dto.setMemname(rs.getString("memname"));
				dto.setPwd(rs.getString("pwd"));
				dto.setAge(rs.getInt("age"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setJob(rs.getString("job"));
				dto.setAddr(rs.getString("addr"));
				dto.setRegdate(rs.getString("regdate"));
			}
			
			// open 객체 닫기
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return dto;
	}  // contentMember() 메서드 end
	
	
	// member10 테이블에서 회원의 정보를 수정하는 메서드
	public int updateMember(MemberDTO dto) {
		
		int result = 0;
		
		try {
			
			openConn();
			
			sql = "select * from member10 where num = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getNum());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(dto.getPwd().equals(rs.getString("pwd"))) {
					sql = "update member10 set "
							+ " age = ?, mileage = ?, "
							+ " job = ?, addr = ? "
							+ " where num = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, dto.getAge());
					pstmt.setInt(2, dto.getMileage());
					pstmt.setString(3, dto.getJob());
					pstmt.setString(4, dto.getAddr());
					pstmt.setInt(5, dto.getNum());
					
					result = pstmt.executeUpdate();
				}else {  // 비밀번호가 틀린 경우
					result = -1;
				}
			}
			
			// open 객체 닫기
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}  // updateMember() 메서드 end
	
	
	// member10 테이블에서 회원번호에 해당하는 회원을 삭제하는 메서드
	public int deleteMember(int num, String pwd) {
		
		int result = 0;
		
		
		
		try {
			
			openConn();
			
			sql = "select * from member10 where num = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(pwd.equals(rs.getString("pwd"))) {
					sql = "delete from member10 "
							+ " where num = ?";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, num);
					
					result = pstmt.executeUpdate();
				}else {  // 비밀번호가 틀린 경우
					result = -1;
				}
			}
			
			// open 객체 닫기
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}  // deleteMember() 메서드 end
	
}
