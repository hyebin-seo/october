package sist;

import java.util.Scanner;

/*
 * [문제2] 1부터 사용자가 키보드로부터 입력을 받은 수 까지의 홀수의 합과 짝수의 합을 구해보자. 
 */

public class Exam_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 >>> ");
		int num = sc.nextInt();
		
		int odd = 0, even = 0; // 전역변수
		
		for(int i=1; i<=num; i++) {
			if(i % 2 == 1) {
				odd += i;
			} else {
				even += i;
			}
		}
		
		System.out.println("1부터 " + num +"까지");
		System.out.println("홀수의 합 >>> " + odd);
		System.out.println("짝수의 합 >>> " + even);

		sc.close();
	}

}
