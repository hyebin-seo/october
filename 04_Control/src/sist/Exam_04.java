package sist;

/*
 * [문제4] 알파벳을 역순으로 출력해보자.
 */

public class Exam_04 {

	public static void main(String[] args) {
		
		for(char c='Z'; c>='A'; c--) {
			for(char d='A'; d<=c; d++) {
				System.out.print(d);
			}
			System.out.println();
		}
		
		System.out.println();
		
		// ASCII코드를 이용하는 방법
		for(int i=90; i>=65; i--) {
			for(int j=65; j<=i; j++) {
				System.out.print((char)j);
			}
			System.out.println();
		}

	}

}
