package sist;

import java.util.Scanner;

/*
 * 배열에 데이터를 저장
 * 내림차순으로 정렬하는 방법
 * 예) 19, 43, 6, 97, 65
 * ==> 97, 65, 43, 19, 6
 */
public class Ex09 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수형 배열의 크기 : ");
		
		int[] score = new int[sc.nextInt()];
		
		for(int i=0; i<score.length; i++) {
			
			System.out.print((i+1)+"번째 정수 입력 : ");
			
			score[i] = sc.nextInt();
		}
		
		
		// 내림차순으로 정렬
		int temp = 0;    // 임시적으로 저장될 변수
		
		for(int i=0; i<score.length; i++) {
			for(int j=i+1; j<score.length; j++) {
				if(score[j] > score[i]) {
					temp = score[i];
					score[i] = score[j];
					score[j] = temp;
				}
			}
		}
		
		// 내림차순으로 정렬된 데이터를 화면에 출력해 보자.
		for(int i=0; i<score.length; i++) {
			System.out.print(score[i] + "\t");
		}
		
		System.out.println();
		
		sc.close();
		
	}

}
