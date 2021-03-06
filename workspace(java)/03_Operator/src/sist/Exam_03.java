package sist;

/*
 * 키보드로 상품과 해당 상품의 단가, 수량, 입금액을 입력 받아서
 * 상품금액(단가*수량)과 부가세액, 상품총액 및 잔액을 구해보자.
 */

public class Exam_03 {

	public static void main(String[] args) {
		// 1. 키보드로부터 상품명을 입력 받자.
		String product = args[0];
		
		// 2. 키보드로부터 상품의 단가를 입력 받자
		int danga = Integer.parseInt(args[1]);
		
	    // 3. 키보드로부터 상품의 수량을 입력 받자
		int amount = Integer.parseInt(args[2]);
		
		// 4.키보드로부터 입금액을 입력 받자
		int money = Integer.parseInt(args[3]);
		
		// 5. 상품 금액을 계산해 보자
		//    공식) 상품의 단가 * 수량
		int sum = danga * amount;
		
		// 6. 상품의 부가세액을 계산해 보자
		//    공식) 1) (단가 * 수량) * 0.1, 2) 상품 금액 * 0.1
		int vat = (int)(sum * 0.1);
		
		// 7. 상품의 총금액을 계산해 보자.
		//    공식) 상품 금액 + 부가세액
		int total = sum + vat;
		
		// 8. 잔액(거스름돈)을 계산해 보자.
		//    공식) 입금액 - 상품의 총금액
		int change = money - total; 
		
		// 9. 화면에 출력해 보자
		System.out.println("상 품 명 : " + product);
		System.out.printf("상품단가 : %,d원\n", danga);
		System.out.println("상품수량 : " + amount);
		System.out.printf("입 금 액 : %,d원\n", money);
		System.out.printf("상품금액 : %,d원\n", sum);
		System.out.printf("부가세액 : %,d원\n", vat);
		System.out.printf("총 금 액 : %,d원\n", total);
		System.out.printf("잔     액 : %,d원\n", change);

	}

}
