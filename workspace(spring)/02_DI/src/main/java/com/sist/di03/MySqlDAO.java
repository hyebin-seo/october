package com.sist.di03;

public class MySqlDAO implements DAO{
	public MySqlDAO() {
		System.out.println("MySqlDAO ������!!");
	}
	
	@Override
	public void add() {
		System.out.println("MySqlDAO ����");
	}
}
