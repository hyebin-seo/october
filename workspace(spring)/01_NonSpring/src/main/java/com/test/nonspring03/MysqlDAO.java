package com.test.nonspring03;

public class MysqlDAO implements DAO{

	public MysqlDAO() {
		System.out.println("MysqlDAO 생성자입니다.");
	}
	
	@Override
	public void add() {
		System.out.println("MysqlDAO 입니다.");
	}
	
}
