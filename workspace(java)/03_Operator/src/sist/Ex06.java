package sist;

/*
 *  6. 비트연산자
 *     - 비트(0,1)를 이용하여 연산하는 연산자.
 *     - &(and) : 두 비트의 조건이 참(1)인 경우 1을 반환, 그 외에는 0을 반환.
 *     - |(or) : 두 비트 중 하나만 조건이 참(1)이어도 경우 1을 반환, 그 외에는 0을 반환.
 *     - ^(xor) : 두 비트 중 서로 다른 경우에만 1을 반환, 그 외에는 0을 반환.
 */

public class Ex06 {

	public static void main(String[] args) {
		
		// 십진수
		int num1 = 10, num2 = 5, result;
		
		// 십진수를 이진수로 변환
		// num1 = 1010, num2 = 0101
		
		// and 연산
		result = num1 & num2; // 1010 & 0101 ==> 0000
		System.out.println("and result >>> " + result);
		
		// or 연산
		result = num1 | num2; // 1010 | 0101 ==> 1111
		System.out.println("or result >>> " + result);
		
		// xor 연산
		num2 = 8;
		result = num1 ^ num2; // 1010 ^ 1000 ==> 0010
		System.out.println("xor result >>> " + result);

	}
	

}
