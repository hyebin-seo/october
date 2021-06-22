package com.user;

public class Main {

	public static void main(String[] args) {
		ConnectionMaker connectionMaker = new AConnectionMaker();
		UserDAO dao = new UserDAO(connectionMaker);
		
		UserDTO dto = new UserDTO();
		
		dto.setId("hong");
		dto.setName("ȫ�浿");
		dto.setPwd("1234");
		
//		dto.setId("leess");
//		dto.setName("�̼���");
//		dto.setPwd("1234");
		
//		UserDAO dao = new UserDAO(connectionMaker);
//		dao.add(dto);
//		
//		System.out.println(dto.getId() + " ��� ����!");
//		System.out.println("==============================");
		
		UserDTO user = dao.getUser("hong");
		System.out.println("���̵� >>> "+user.getId());
		System.out.println("�̸� >>> "+user.getName());
		System.out.println("��й�ȣ >>> "+user.getPwd());
		
		dao.getUser("leess");
	}

}
