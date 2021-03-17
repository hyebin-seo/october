package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.StudentDTO;

/*
 * [문제] Ex04 클래스처럼 키보드로 학생수를 입력 받고
 *       입력받은 학생 수만큼 정보를 키보드로 입력 받아서
 *       ArrayList에 정보를 저장 후 화면에 출력하시오.
 */

public class Ex05 {
	
	public static void main(String[] args) {
		
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수를 입력하세요. : ");

		int count = sc.nextInt();

		for(int i=0; i<count; i++) {
			StudentDTO student = new StudentDTO();
			
			System.out.println((i+1)+"번째 학생의 "
					+"학번, 이름, 학과, 연락처, 주소를 입력하세요...");
			
			student.setHakbun(sc.nextInt());
			student.setName(sc.next());
			student.setMajor(sc.next());
			student.setPhone(sc.next());
			student.setAddress(sc.next());

			list.add(student);
			System.out.println("::::::::::::::::::::::::::::::::::::::");
			
		}
		
		System.out.println("학   번\t\t이   름\t학   과\t연락처\t\t주   소");
		
		for(int i=0; i<list.size(); i++) {
			StudentDTO student = list.get(i);
			System.out.println(student.getHakbun()+"\t"
							  +student.getName()+"\t"
							  +student.getMajor()+"\t"
							  +student.getPhone()+"\t"
							  +student.getAddress());
			System.out.println("=======================================");
		}
		
		sc.close();

	}
}
