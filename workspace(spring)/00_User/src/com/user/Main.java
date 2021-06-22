package com.user;

public class Main {

	public static void main(String[] args) {
		ConnectionMaker connectionMaker = new AConnectionMaker();
		UserDAO dao = new UserDAO(connectionMaker);
		
		UserDTO dto = new UserDTO();
		
		dto.setId("hong");
		dto.setName("홍길동");
		dto.setPwd("1234");
		
//		dto.setId("leess");
//		dto.setName("이순신");
//		dto.setPwd("1234");
		
//		UserDAO dao = new UserDAO(connectionMaker);
//		dao.add(dto);
//		
//		System.out.println(dto.getId() + " 등록 성공!");
//		System.out.println("==============================");
		
		UserDTO user = dao.getUser("hong");
		System.out.println("아이디 >>> "+user.getId());
		System.out.println("이름 >>> "+user.getName());
		System.out.println("비밀번호 >>> "+user.getPwd());
		
		dao.getUser("leess");
	}

}
