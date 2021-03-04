package method;

import java.util.Scanner;

// 계산기 예제

public class Ex04 {
	
	public static void plus(int su1, int su2) {
		System.out.println("연산 결과 >>> " +su1+ "+" +su2+ "=" + (su1 + su2));
	}
	
	public static void minus(int su1, int su2) {
		System.out.println("연산 결과 >>> " +su1+ "-" +su2+ "=" + (su1 - su2));
	}
	
	public static void mul(int su1, int su2) {
		System.out.println("연산 결과 >>> " +su1+ "*" +su2+ "=" + (su1 * su2));
	}
	
	public static void divide(int su1, int su2) {
		System.out.println("연산 결과 >>> " +su1+ "/" +su2+ "=" + (su1 / su2));
	}
	
	public static void mod(int su1, int su2) {
		System.out.println("연산 결과 >>> " +su1+ "%" +su2+ "=" + (su1 % su2));
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 키보드로부터 두 개의 정수와 연산자를 입력 받기
		System.out.print("첫번째 정수 입력 : ");
		int su1 = sc.nextInt();
		
		System.out.print("두번째 정수 입력 : ");
		int su2 = sc.nextInt();
		
		System.out.print("연산자 입력 : ");
		String op = sc.next();
		
		// 2. 연산자 변수에 입력된 연산기호를 가지고 해당 기호에 맞는 메서드 호출
		switch(op) {
		case "+":
			plus(su1, su2);
			break;
		case "-":
			minus(su1, su2);
			break;
		case "*":
			mul(su1, su2);
			break;
		case "/":
			divide(su1, su2);
			break;
		case "%":
			mod(su1, su2);
			break;
		}
		
		sc.close();

	}

}
