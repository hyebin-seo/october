package sist;

import java.util.Scanner;

public class Ex20 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("*** 메뉴를 선택하세요. ***");
		System.out.println("1. Pizza");
		System.out.println("2. 돈까스");
		System.out.println("3. 제육볶음");
		System.out.println("4. 김치찌개");
		System.out.println("5. 짜장면");
		System.out.print("위 메뉴 중 하나를 선택하세요. : ");
		int menu = sc.nextInt();
		
		switch (menu) {
		case 1:
			System.out.println("Pizza 선택");
			break;
		case 2:
			System.out.println("돈까스 선택");
			break;
		case 3:
			System.out.println("제육볶음 선택");
			break;
		case 4:
			System.out.println("김치찌개 선택");
			break;
		case 5:
			System.out.println("짜장면 선택");
			break;
		default:
			System.out.println("위 메뉴 중 하나를 선택해주세요.");
			break;
		}
		
		sc.close();

	}

}
