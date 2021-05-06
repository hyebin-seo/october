package com.sist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * DAO(Data Access Object) : 데이터 접근 객체 ==> DB에 접속(연동)하는 객체.
 * - DAO란 데이터베이스에 접속해서 데이터 추가, 수정, 삭제, 조회 등의 작업을 하는 클래스.
 * - 일반적으로 JSP 또는 Servlet에서 위의 작업들을 같이 사용할 수 있지만
 *   유지보수, 코드의 모듈화를 위해서 DAO 클래스를 따로 만들어서 사용을 함.
 */

public class EmpDAO {

	Connection con = null;            // DB와 연결하는 객체.
	PreparedStatement pstmt = null;   // DB에 SQL문을 전송하는 객체.
	ResultSet rs = null;              // SQL문을 실행 후 결과 값을 가지고 있는 객체.
	String sql = null;                // 쿼리문을 저장할 객체.
	
	
	public EmpDAO() {   // 기본 생성자
		
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
	
	
	// EMP 테이블에서 전체 리스트를 조회하는 메서드
	public List<EmpDTO> selectList() {
		List<EmpDTO> list = new ArrayList<EmpDTO>();  // 다형성
		
		System.out.println("selectList() 메서드에서 list >>> " + list);
		
		
		try {
			sql = "select * from emp order by empno desc";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpDTO dto = new EmpDTO();
				
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setMgr(rs.getInt("mgr"));
				dto.setHiredate(rs.getString("hiredate"));
				dto.setSal(rs.getInt("sal"));
				dto.setComm(rs.getInt("comm"));
				dto.setDeptno(rs.getInt("deptno"));
				
				list.add(dto);
			}
			
			// open 객체 닫기
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("데이터 완료 후 >>> " + list);
		return list;
	}  // selectList() 메서드 end
	
	// dept 테이블의 전체 리스트를 조회하는 메서드
	public List<DeptDTO> deptList() {
		List<DeptDTO> deptList = new ArrayList<DeptDTO>();
		
		try {
			sql = "select * from dept order by deptno";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DeptDTO dto = new DeptDTO();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				
				deptList.add(dto);
			}
			
			// open 객체 닫기
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return deptList;
	}  // deptList() 메서드 end
	
	// EMP 테이블에 사원을 등록(추가)하는 메서드
	public int insertEmp(EmpDTO dto) {
		int result = 0;
		
		try {
			sql = "insert into emp "
					+ " values(?, ?, ?, ?, sysdate, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getEmpno());
			pstmt.setString(2, dto.getEname());
			pstmt.setString(3, dto.getJob());
			pstmt.setInt(4, dto.getMgr());
			pstmt.setInt(5, dto.getSal());
			pstmt.setInt(6, dto.getComm());
			pstmt.setInt(7, dto.getDeptno());
			
			result = pstmt.executeUpdate();
			
			// open 객체 닫기
			pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}  // insertEmp() 메서드 end
	
	// EMP 테이블에서 사원번호에 해당하는 사원을 삭제하는 메서드
	public int deleteEmp(int num) {
		int result = 0;
		
		try {
			sql = "delete from emp where empno = ?";
		
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
	}  // deleteEmp() 메서드 end
	
}






