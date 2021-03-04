package sist;

import java.util.Scanner;

/*
 * [문제1] 배열의 크기를 키보드로 입력 받고 입력 받은 배열의 크기만큼
 * 키보드로 정수를 입력 받아서 최대값과 최소값을 화면에 출력해보세요.
 */

public class Exam_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기 입력 : ");
		int[] arr = new int[sc.nextInt()];
		
		// 최대값 변수, 최소값(99->두자리수 제한) 변수 선언
		int max = 0, min = 99;
		
		// 배열에 키보드를 이용하여 임의의 정수를 입력을 받자.
		for(int i=0; i<arr.length; i++) {
			System.out.print((i+1)+"번째 정수 입력 >>>");
			arr[i] = sc.nextInt();
			
			// 최대값을 구해 보자.
			if(arr[i] > max) {
				max = arr[i];
			}
			
			// 최소값을 구해 보자.
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		
		System.out.println("최대값 >>> " + max);
		System.out.println("최소값 >>> " + min);
		
		sc.close();

	}

}
