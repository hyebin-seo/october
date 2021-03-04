package sist;

import java.util.Scanner;

/*
 * [문제] 배열에 5개의 정수를 키보드를 이용하여 저장 후에
 *       배열에 저장된 정수를 화면에 출력해 보세요.
 *       (단, 일반 for문과 단축 for문을 이용하여 출력해 볼 것)
 */

public class Ex03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 배열 선언 및 배열 메모리 생성
		int[] arr = new int[5];
		
		// 2. 배열의 초기화 작업
		//    => 5개의 정수를 키보드로 입력을 받아서 배열에 저장.
		for(int i=0; i<5; i++) {
			System.out.print((i+1) +"번째 정수 입력 >>> ");
			arr[i] = sc.nextInt();
		}
		System.out.println();
		
		// 3. 배열에 저장된 5개의 정수를 for문을 이용하여 출력.
		for(int i=0; i<5; i++) {
			System.out.println("arr["+i+"] >>> " + arr[i]);
		}
		
		// 4. 배열에 저장된 5개의 정수를 단축 for문을 이용하여 출력.
		for(int k : arr) {
			System.out.println("arr 배열의 요소 >>> " + k);
		}
		
		sc.close();

	}

}
