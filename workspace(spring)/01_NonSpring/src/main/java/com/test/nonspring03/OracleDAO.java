package com.test.nonspring03;

public class OracleDAO implements DAO{

	public OracleDAO() {
		System.out.println("OracleDAO 생성자입니다.");
	}
	
	@Override
	public void add() {
		System.out.println("OracleDAO 입니다.");
	}

}
