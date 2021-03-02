package sist;

/*
 * 다중 if~else문 - 조건문
 * - 여러 개의 조건문 중에 맞는 조건에 해당하는 문장을 실행하는 구조.
 * 형식)
 *       if(조건식1) {
 *           조건식1이 참인 경우 실행문;
 *       } else {
 *            if(조건식2) {
 *                 조건식1이 거짓이고, 조건식 2가 참인 경우 실행문;
 *            } else {
 *                 if(조건식3) {
 *                     조건식1, 조건식2가 거짓이고, 조건식3이 참인 경우 실행문;
 *                 } else {
 *                      조건식1, 조건식2, 조건식3이 모두 거짓인 경우 실행문;
 *                 }
 *            }
 *       }
 *       
 *       if(조건식1) {
 *            조건식1이 참인 경우 실행문;
 *       } else if(조건식2) {
 *            조건식1이 거짓이고, 조건식2가 참인 경우 실행문;
 *       } else if(조건식3) {
 *            조건식1, 조건식2가 거짓이고, 조건식3이 참인 경우 실행문;
 *       } else {
 *            조건식1, 조건식2, 조건식3이 모두 거짓인 경우 실행문;
 *       }
 */

public class Ex13 {

	public static void main(String[] args) {
		
		int num = 3;
		
		if(num == 1) {
			System.out.println("입력된 숫자는 1입니다.");
		} else if(num == 2) {
			System.out.println("입력된 숫자는 2입니다.");
		} else if(num == 3) {
			System.out.println("입력된 숫자는 3입니다.");
		} else {
			System.out.println("1~3 이외의 숫자입니다.");
		}

	}

}
