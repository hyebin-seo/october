package com.test.nonspring03;

public class OracleDAO implements DAO{

	public OracleDAO() {
		System.out.println("OracleDAO �������Դϴ�.");
	}
	
	@Override
	public void add() {
		System.out.println("OracleDAO �Դϴ�.");
	}

}
