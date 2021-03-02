package sist;

import java.util.Scanner;

public class Exam_03_02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("별의 최대 갯수를 입력하세요. : ");
		int star = sc.nextInt();
		
		// 전체 라인 수는 (입력 받은 별의 최대개수*2-1)이 되어야함.
		for(int i=1; i<=(star*2-1); i++) {
			
			int line = (i <= star) ? i : (star*2-i);
			
			for(int j = 1; j<=line; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		sc.close();

	}

}
