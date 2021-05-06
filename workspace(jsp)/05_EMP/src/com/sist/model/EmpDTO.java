package com.sist.model;

// DTO(Data Transfer Object) : ������ ���� ��ü
// �⺻������ DB ���� ���̺��� �÷��� �����ϰ� ������� ����.

public class EmpDTO {
	private int empno; 			//��� ��ȣ
	private String ename; 		//�����
	private String job; 		//������
	private int mgr; 			//������ ��� ��ȣ
	private String hiredate; 	//�Ի� ����
	private int sal; 			//��� �޿�
	private int comm; 			//��� ���ʽ�
	private int deptno; 		//��� �μ� ��ȣ
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
}
