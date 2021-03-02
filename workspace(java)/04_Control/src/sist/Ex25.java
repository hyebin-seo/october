package sist;

public class Ex25 {

	public static void main(String[] args) {
		
		// ABCDEFGHIJKLMN.....XYZ 문자를 출력해보자.
		char alpha = 'A'; // 반복문에서 초기식
		while(alpha <= 'Z') {
			System.out.print(alpha);
			alpha++;
		}
		
		System.out.println();
		
		// ZYXWV.....DBCA 문자를 출력해 보자.
		char alpha1 = 'Z';
		while(alpha1 >= 'A') {
			System.out.print(alpha1);
			alpha1--;
		}
	}

}
