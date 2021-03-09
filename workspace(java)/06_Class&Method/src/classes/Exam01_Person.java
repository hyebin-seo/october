package classes;

import java.util.Scanner;

public class Exam01_Person {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름, 성별(male/female), 나이를 입력하세요...");
		Person person2 = new Person(sc.nextLine(), sc.nextLine(), sc.nextInt());
		System.out.println("==========================");
		person2.showPersonInfo2();
		
		sc.close();
	}

}
