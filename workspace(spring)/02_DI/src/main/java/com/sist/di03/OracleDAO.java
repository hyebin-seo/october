package com.sist.di03;

public class OracleDAO implements DAO {

	public OracleDAO() {
		System.out.println("OracleDAO ������!!");
	}
	
	@Override
	public void add() {
		System.out.println("oracleDAO ����");
	}

}
