package classes;

import java.util.Scanner;

public class Exam06_Menu {

	public static final double TAX_RATE = 1.1;  // 상수
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메뉴는 몇개인가요? : ");
		
		Menu[] menus = new Menu[sc.nextInt()];
		
		// 메뉴와 단가, 수량을 키보드로 입력받아서 객체 배열에 저장을 해 주자.
		for(int i=0; i<menus.length; i++) {
			System.out.println
				((i+1)+"번째 메뉴의 품명, 단가, 수량을 입력하세요...");
			menus[i] = new Menu
					(sc.next(), sc.nextInt(), sc.nextInt());
		}
		
		System.out.println();
		
		int totalPrice = 0;     // 총금액 변수
		
		System.out.println("---------------------------------");
		System.out.println("품명\t단가\t수량\t금액");
		System.out.println("---------------------------------");
		
		for(int i=0; i<menus.length; i++) {
			System.out.printf("%s\t%,6d\t%3d\t%,6d원\n",
					menus[i].name, menus[i].unitPrice,
					menus[i].count, (menus[i].unitPrice * menus[i].count));
			totalPrice += (menus[i].unitPrice * menus[i].count);
		}
		
		// 공급가액을 구하자 = 총금액 / 1.1
		int supplyPrice = (int)(totalPrice / Exam06_Menu.TAX_RATE);
		
		// 부가세액을 구하자 = 총금액 - 공급가액
		int vat = totalPrice -supplyPrice;
		
		System.out.println("---------------------------------");
		System.out.printf("공급가액\t\t\t%,6d원\n", supplyPrice);
		System.out.printf("부가세액\t\t\t%,6d원\n", vat);
		System.out.println("---------------------------------");
		System.out.printf("청구금액\t\t\t%,6d원\n", totalPrice);
		
		sc.close();
	}

}
