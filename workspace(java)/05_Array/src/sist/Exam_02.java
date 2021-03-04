package sist;

import java.util.Scanner;

public class Exam_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] score = new int[5];
		
		// 키보드로부터 5개의 정수를 입력을 받자.
		for(int i=0; i<score.length; i++) {
			System.out.print((i+1)+"번째 정수 입력 >>> ");
			score[i] = sc.nextInt();
		}
		
		// 내림차순 정렬을 진행해 보자.
		int temp = 0;
		
		for(int i=0; i<score.length; i++) {
			for(int j=i+1; j<score.length; j++) {
				if(score[j] > score[i]) {
					temp = score[i];
					score[i] = score[j];
					score[j] = temp;
				}
			}
		}
		
		System.out.println();
		System.out.println("*** 내림차순으로 정렬 ***");
		
		for(int i=0; i<score.length; i++) {
			System.out.println(score[i]+"\t");
		}
		
		sc.close();
	}

}
