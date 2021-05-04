package com.sist.model;

// 자바 빈(액션 태그에서 사용하려는 useBean)을 사용하기 위해서는
// 폼 창의 name에 들어간 변수명과 DTO 객체의 멤버변수명이 일치해야 함.
public class MemberDTO {
	private String memid;
	private String memname;
	private String pwd;
	private int age;
	private int mileage;
	private String job;
	private String addr;
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
	
	
}
