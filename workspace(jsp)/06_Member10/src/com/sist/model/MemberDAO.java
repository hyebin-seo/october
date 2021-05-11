package com.sist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	Connection con = null;              // DB 연결하는 객체.
	PreparedStatement pstmt = null;     // DB에 SQL문을 전송하는 객체.
	ResultSet rs = null;                // SQL문을 실행 후 결과 값을 가지고 있는 객체.
	
	String sql = null;                  // 쿼리문을 저장할 객체.
	
	
	public MemberDAO() {  // 기본 생성자
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "web";
		String password = "1234";
		
		
		try {
			// 1단계 : 오라클 드라이버 로딩
			Class.forName(driver);
			
			// 2단계 : DB(오라클)와 연결
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}  // 기본 생성자 end
	
	
	// member10 테이블에서 전체 회원 목록을 조회하는 메서드
	public List<MemberDTO> getMemberList() {
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		try {
			sql = "select * from member10 order by num desc";
			
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
	
	
	// member10 테이블에 데이터를 저장하는 메서드
	public int insertMember(MemberDTO dto) {
		
		int result = 0;
		
		try {
			sql = "insert into member10 "
					+ " values(member10_seq.nextval,?,?,?,?,?,?,?,sysdate)";
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
	
	
	// 회원 번호에 해당하는 회원의 정보를 조회하는 메서드
	public MemberDTO contentMember(int no) {
		
		MemberDTO dto = new MemberDTO();
		
		try {
			sql = "select * from member10 where num = ?";
			
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
	
	
	// member10 테이블에서 회원번호에 해당하는 회원의 정보를 수정하는 메서드
	public int updateMember(MemberDTO dto) {
		
		int result = 0;
		
		try {
			sql = "update member10 set pwd = ?, age = ?, "
					+ " mileage = ?, job = ?, "
					+ " addr = ? where num = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPwd());
			
			pstmt.setInt(2, dto.getAge());
			
			pstmt.setInt(3, dto.getMileage());
			
			pstmt.setString(4, dto.getJob());
			
			pstmt.setString(5, dto.getAddr());
			
			pstmt.setInt(6, dto.getNum());
			
			result = pstmt.executeUpdate();
			
			// open 객체 닫기
			pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}  // updateMember() 메서드 end
	
	// 회원번호에 해당하는 회원을 DB에서 삭제하는 메서드
	public int deleteMember(int num) {
		int result = 0;
		
		try {
			sql = "delete from member10 where num = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			result = pstmt.executeUpdate();
			
			// open 객체 닫기
			pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
		
	}  // deleteMember() 메서드 end
	
	
}
