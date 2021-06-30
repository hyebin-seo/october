package com.spring.model;

import lombok.Data;

@Data
public class EmpDTO {

	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private double sal;
	private double comm;
	private int deptno;
	
}
