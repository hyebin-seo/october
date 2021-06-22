package com.test.nonspring03;

public class Main {

	public static void main(String[] args) {
		// ������ Java, JSP���� ����ϴ� ���
		MysqlDAO mydao = new MysqlDAO();
		mydao.add();
		
		OracleDAO oradao = new OracleDAO();
		oradao.add();
		
		System.out.println("================");
		
		// 1. �����ڸ� �̿��Ͽ� �����ϴ� ���
		ServiceImpl impl1 = new ServiceImpl(new MysqlDAO());
		impl1.biz();
		
		// 2. setter() �޼��带 �̿��Ͽ� �����ϴ� ���
		ServiceImpl impl2 = new ServiceImpl();
		impl2.setDao(new OracleDAO());
		impl2.biz();
	}

}
