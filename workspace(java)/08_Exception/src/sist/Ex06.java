package sist;

import java.util.Scanner;

// Ex03 클래스에서 발생한 예외를 예외 처리 코드를
// 이용하여 예외를 처리해 주세요.

public class Ex06 {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		Scanner sc = new Scanner(System.in);
		
		int su = 0;
		
		try {
			System.out.print("정수를 입력하세요. : ");
			su = sc.nextInt();  // 예외가 발생할 가능성이 있는 코드
		}catch(Exception e) {
			System.out.println("정수만 입력하세요.~~~");
			System.out.println("예외 정보 >>> " + e);
		}finally {
			sc.close();
		}
		
		System.out.println("입력 받은 수 >>> " + su);
		
		System.out.println("프로그램 종료");

	}

}
