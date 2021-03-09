package classes;

import java.util.Scanner;

public class Ex10_Drink {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("자판기 음료 갯수를 입력하세요. : ");
		
		// 객체 배열을 만들어 보자.
		Drink[] drinks = new Drink[sc.nextInt()];
		
		for(int i=0; i<drinks.length; i++) {
			System.out.println("음료 이름과 가격을 입력하세요...");
			System.out.println("::::::::::::::::::::::::");
			drinks[i] = new Drink(sc.next(), sc.nextInt());
		}
		
		System.out.println(drinks[0]);
		System.out.println(drinks[1]);
		System.out.println(drinks[2]);
		
		System.out.println("돈을 입력해 주세요. : ");
		
		int coin = sc.nextInt();
		
		// 입력을 받은 coin과 객체 배열에 저장된 Drink 클래스가 가지고 있는
		// price 가격을  비교해서 coin보다 작거나 같은 음료를 선택
		for(int i=0; i<drinks.length; i++) {
			if(coin  >= drinks[i].price) {
				System.out.print(drinks[i].name + "\t");
			}
		}
		
		sc.close();
	}

}
