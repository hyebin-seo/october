package com.sist.model;

// Member10 테이블의 컬럼과 동일하게 멤버변수 구성

public class MemberDTO {

	private int num;            // 회원 번호
	private String memid;       // 회원 아이디
	private String memname;     // 회원 이름
	private String pwd;         // 회원 비밀번호
	private int age;            // 회원 나이
	private int mileage;        // 회원 마일리지
	private String job;         // 회원 직업
	private String addr;        // 회원 주소
	private String regdate;     // 회원 가입일
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getMemname() {
		return memname;
	}
	public void setMemname(String memname) {
		this.memname = memname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
