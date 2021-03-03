package sist;

import java.util.Scanner;

/*
 * [문제] 배열에 5개의 정수를 키보드를 이용하여 저장 후에 배열에 저장된 정수를 화면에 출력
 * 단, 일반 for문과 단축 for문을 이용하여 출력)
 */

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[5];
		
		for(int i=0; i<5; i++) {
			System.out.print((i+1) + "번 정수를 입력하세요 >>> ");
			num[i] = sc.nextInt();
		}
		
		for(int i=0; i<5; i++) {
			System.out.println((i+1) + "번 정수 >>> " + num[i]);
		}
		
		for(int su : num) {
			System.out.println("정수 >>> " + su);
		}
		
		sc.close();
		

	}

}
