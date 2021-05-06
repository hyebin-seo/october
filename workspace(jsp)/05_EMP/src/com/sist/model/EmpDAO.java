package com.sist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * DAO(Data Access Object) : ������ ���� ��ü ==> DB�� ����(����)�ϴ� ��ü.
 * - DAO�� �����ͺ��̽��� �����ؼ� ������ �߰�, ����, ����, ��ȸ ���� �۾��� �ϴ� Ŭ����.
 * - �Ϲ������� JSP �Ǵ� Servlet���� ���� �۾����� ���� ����� �� ������
 *   ��������, �ڵ��� ���ȭ�� ���ؼ� DAO Ŭ������ ���� ���� ����� ��.
 */

public class EmpDAO {

	Connection con = null;            // DB�� �����ϴ� ��ü.
	PreparedStatement pstmt = null;   // DB�� SQL���� �����ϴ� ��ü.
	ResultSet rs = null;              // SQL���� ���� �� ��� ���� ������ �ִ� ��ü.
	String sql = null;                // �������� ������ ��ü.
	
	
	public EmpDAO() {   // �⺻ ������
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "web";
		String password = "1234";
		
		
		try {
			// 1�ܰ� : ����Ŭ ����̹� �ε�
			Class.forName(driver);
			
			// 2�ܰ� : DB(����Ŭ)�� ����
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}  // �⺻ ������ end
	
	
	// EMP ���̺��� ��ü ����Ʈ�� ��ȸ�ϴ� �޼���
	public List<EmpDTO> selectList() {
		List<EmpDTO> list = new ArrayList<EmpDTO>();  // ������
		
		System.out.println("selectList() �޼��忡�� list >>> " + list);
		
		
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
			
			// open ��ü �ݱ�
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("������ �Ϸ� �� >>> " + list);
		return list;
	}  // selectList() �޼��� end
	
	// dept ���̺��� ��ü ����Ʈ�� ��ȸ�ϴ� �޼���
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
			
			// open ��ü �ݱ�
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return deptList;
	}  // deptList() �޼��� end
	
	// EMP ���̺� ����� ���(�߰�)�ϴ� �޼���
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
			
			// open ��ü �ݱ�
			pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}  // insertEmp() �޼��� end
	
	// EMP ���̺��� �����ȣ�� �ش��ϴ� ����� �����ϴ� �޼���
	public int deleteEmp(int num) {
		int result = 0;
		
		try {
			sql = "delete from emp where empno = ?";
		
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			result = pstmt.executeUpdate();
			
			// open ��ü �ݱ�
			pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}  // deleteEmp() �޼��� end
	
}






