package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.MemberDTO;

public class Ex04 {

	public static void main(String[] args) {
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 수를 입력하세요. : ");

		int count = sc.nextInt();
		
		// 1. 키보드로 회원의 수만큼 회원 정보를 입력 받아서 list에 저장해보자.
		for(int i=0; i<count; i++) {
			MemberDTO dto = new MemberDTO();
			
			System.out.println((i+1)+"번째 회원의 "
					+"아이디, 비밀번호, 이름, 나이, 주소를 입력하세요...");
			
			dto.setId(sc.next());
			dto.setPwd(sc.next());
			dto.setName(sc.next());
			dto.setAge(sc.nextInt());
			dto.setAddress(sc.next());
			
			// 생성된 dto 객체의 '주소값'을 ArrayList에 차례대로 저장한다.
			list.add(dto);
			System.out.println("::::::::::::::::::::::::::::::::::::::");
			
		}
		
		System.out.println("아이디\t비밀번호\t이   름\t나   이\t주   소");
		
		// list에 있는 데이터들을 화면에 출력해보자.
		for(int i=0; i<list.size(); i++) {
			// list에 저장되어있는 '주소값'을 받을 객체
			MemberDTO dto = list.get(i);
			System.out.println(dto.getId()+"\t"
							  +dto.getPwd()+"\t"
							  +dto.getName()+"\t"
							  +dto.getAge()+"\t"
							  +dto.getAddress());
			System.out.println("=======================================");
		}
		
		sc.close();
	}

}
