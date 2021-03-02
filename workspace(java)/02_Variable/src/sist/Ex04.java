package sist;

/*
 * - 단일 문자형 : char형(0 ~ 65535) ==> 2byte
 * - 자바에서는 유니코드 체계로 단일 문자가 처리 됨.
 *   ==> C 언어에서는 ASCII 코드 체계로 처리가 됨.
 */

public class Ex04 {

	public static void main(String[] args) {
		
		char ch = 'A';
		
		System.out.println("ch >>> " + ch);
		
		System.out.println((char)(ch+1));

	}

}
