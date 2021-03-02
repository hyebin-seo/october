package sist;

import java.util.Scanner;

/*
 * 1~100 사이의 정수 중에서 5개의 정수를 입력 받아
 * 5개의 정수 중에서 최대값을 출력해 보자.
 */

public class Ex29 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int max = 0; // 최대값 변수
		
		int temp; 
		
		int su =1; // 반복문에서 초기식
		
		while(su <= 5) {
			System.out.println(su + "번째 정수 입력 : ");
			temp = sc.nextInt();
			
			if(temp > max) {
				max = temp;
			}
			su++;
		}
		
		System.out.println("최대값 >>> " + max);
	
		sc.close();
		
	}

}
