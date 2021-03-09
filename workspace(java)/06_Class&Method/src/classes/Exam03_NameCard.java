package classes;

import java.util.Scanner;

public class Exam03_NameCard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름, 전화번호, 주소, 직급을 입력하세요.");
		NameCard namecard = 
				new NameCard(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
		System.out.println("===============================");
		
		namecard.showInfo();
		
		sc.close();
	
	}

}
