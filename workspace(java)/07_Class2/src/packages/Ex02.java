package packages;

import java.util.Scanner;

import model.MemberDTO;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1. 회원수를 입력 받아서 객체 배열에 회원수를 입력해보자.
		System.out.print("회원수를 입력하세요. : ");
		MemberDTO[] dtos = new MemberDTO[sc.nextInt()];
		
		// 2. 반복문을 이용하여 회원 수만큼 회원 정보를 키보드로 입력을 받자.
		for(int i=0; i<dtos.length; i++) {
			dtos[i] = new MemberDTO();
			
			System.out.println((i+1)+"번째 회원의 아이디, 비밀번호, 이름, 나이, 주소를 입력하세요...");
			
			dtos[i].setId(sc.next());
			dtos[i].setPwd(sc.next());
			dtos[i].setName(sc.next());
			dtos[i].setAge(sc.nextInt());
			dtos[i].setAddress(sc.next());
		}
		
		System.out.println("아이디\t비밀번호\t이름\t나이\t주소");
		
		for(int i=0; i<dtos.length; i++) {
			System.out.println(dtos[i].getId()  +"\t"+ 
							   dtos[i].getPwd() +"\t"+
							   dtos[i].getName()+"\t"+
							   dtos[i].getAge() +"\t"+
							   dtos[i].getAddress());
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::");
		}
		
		sc.close();
	}
	
}
