package com.sist.model;

// DTO(Data Transfer Object) : 데이터 전송 객체
// 기본적으로 DB 상의 테이블의 컬럼과 동일하게 멤버변수 구성.

public class EmpDTO {
	private int empno; 			//사원 번호
	private String ename; 		//사원명
	private String job; 		//담당업무
	private int mgr; 			//관리자 사원 번호
	private String hiredate; 	//입사 일자
	private int sal; 			//사원 급여
	private int comm; 			//사원 보너스
	private int deptno; 		//사원 부서 번호
	
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
