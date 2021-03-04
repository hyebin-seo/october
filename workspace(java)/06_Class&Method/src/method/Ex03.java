package method;

import java.util.Scanner;

/*
 * 매개변수가 있는 메서드 정의
 * 형식) [접근제한] 반환형 메서드이름(type 변수1, type 변수2...) {
 * 						메서드 호출 시 실행 문장;
 * 				 }
 * 
 * - 실인수와 가인수
 * * 실인수 : 매개변수에 전달할 실제 값 ==> 메서드를 호출할 때 사용함.
 * * 가인수 : 매개변수 ==> 메서드에 정의.
 * * 실인수와 가인수는 반드시 type, 순서, 갯수가 일치해야 함(중요함). 
 */

public class Ex03 {

	public static void prn() {
		System.out.println("prn() 메소드가 호출되었습니다.");
	}
	
	public static void total(int num) {
		
		int sum = 0;
		
		for(int i=1; i<=num; i++) {
			sum += i;
		}
		
		System.out.println("1부터" + num + "까지의 합 >>> " + sum);
	}
	
	public static void total(int start, int end) {
		
		int sum = 0;
		
		for(int i=start; i<=end; i++) {
			sum += i;
		}
		
		System.out.println(start +"부터 " + end + "까지의 합 >>> " + sum);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("프로그램 시작");
		
		// 일반 메소드
		prn();
		System.out.println();
		
		// 매개변수 1개 메소드
		System.out.print("정수 입력 : ");
		total(sc.nextInt());
		
		// 매개변수 2개 메소드
		System.out.print("시작 숫자 입력 : ");
		int start = sc.nextInt();
		
		System.out.print("마지막 숫자 입력 : ");
		int end = sc.nextInt();
		
		total(start, end);
		
		System.out.println("프로그램 종료");

	}

}
