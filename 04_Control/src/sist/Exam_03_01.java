package sist;

/*
 * *
 * **
 * ***
 * ****
 * *****
 * ****
 * ***
 * **
 * *
 */

public class Exam_03_01 {

	public static void main(String[] args) {
		// 1. 올라가는 별 찍기
		for(int i=1; i<=6; i++) { // i번수 : 라인(행) 수
			for(int j=1; j<=i; j++) { // j변수 : 별의(열) 갯수
				System.out.print("*");
			}
			System.out.println();
		}
				
		// 2. 내려가는 별 찍기
		for(int i=5; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
