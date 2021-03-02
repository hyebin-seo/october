package sist;

/*
 * 2. 반복문
 *    - 반복해서 실행할 때 사용하는 문장.
 *    - 반복문의 종류 : while문, do~while문, for문
 */

/*
 * while 반복문
 * - 조건식을 비교하여 참인 경우 계속해서 반복 실행문을 실행하고,
 *   조건식이 거짓인 경우에는 반복문을 빠져 나가는 문장.
 * - while 반복문은 반복문의 횟수를 알 수 없는 경우에 많이 사용 됨.
 * - 반복문에는 반드시 초기식, 조건식, 증감식이 존재해야 함.
 *   형식) while(조건식) {
 *				반복 실행문;
 *        }
 */

/*
 * do~while 반복문
 * - 먼저 반복 실행문을 실행하고 조건식을 비교함.
 *   형식) do {
 *            반복 실행문;
 *        } while(조건식)
 */

public class Ex23 {

	public static void main(String[] args) {
		
		//while 반복문을 이용하여 1 ~ 10까지 출력해보자.
		int num = 1; // 반복문에서 초기식
		
		while(num <= 10) { // 반복문에서 조건식
			System.out.println("num >>> " + num);
			num++; // 반복문에서 증감식
		}
		
		System.out.println();
		
		int su = 1; // 반복문에서 초기식
		
		do {
			System.out.println("su >>> " + su);
			su++;
		} while(su <= 10);

	}

}
