package com.test.nonspring03;

public class MysqlDAO implements DAO{

	public MysqlDAO() {
		System.out.println("MysqlDAO �������Դϴ�.");
	}
	
	@Override
	public void add() {
		System.out.println("MysqlDAO �Դϴ�.");
	}
	
}
