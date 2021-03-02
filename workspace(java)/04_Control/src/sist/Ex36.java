package sist;
/*
 * 아래와 같이 출력을 해 보자.
 * 
 * *****
 * *****
 * *****
 * *****
 * 
 * 
 * *
 * **
 * ***
 * ****
 * *****
 * 
 * *****
 * ****
 * ***
 * **
 * *
 */
public class Ex36 {

	public static void main(String[] args) {
		
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
//		for(int i=1; i<=5; i++) {
//			for(int j=5; j>=i; j--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		for(int i=5; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
