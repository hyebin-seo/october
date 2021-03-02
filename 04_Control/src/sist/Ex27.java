package sist;

import java.util.Scanner;

/*
 * [문제] 키보드로 입력을 받은 수 까지의 홀수의 합과 짝수의 합을 구하여 화면에 출력해 보자.
 */

public class Ex27 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		int su = 1; // 반복문에서 초기식
		
		// 홀수의 합 누적변수, 짝수의 합 누적 변수
		int odd = 0, even = 0;
		
		while(su <= num) {
			if(su % 2 == 1) {
				odd += su;
			} else {
				even += su;
			}
			su++;
		}
		
		System.out.println("입력 받은 수 >>> " + num);
		System.out.println("홀수의 합 >>> " + odd);
		System.out.println("짝수의 합 >>> " + even);
		
		sc.close();

	}

}
