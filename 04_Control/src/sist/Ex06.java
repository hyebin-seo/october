package sist;

import javax.swing.JOptionPane;

/*
 * if~else문 - 조건문
 * - 조건식이 참이면 조건식이 참인 경우 실행문을 실행을 하고 if~else문을 빠져 나옴.
 * - 조건식이 거짓이면 조건식이 거짓인 경우 실행문을 실행을 하고 if~else문을 빠져 나옴.
 *   형식) if(조건식) {
 *            조건식이 참인 경우 실행문.
 *        } else {
 *            조건식이 거짓인 경우 실행문.
 *        }
 */

public class Ex06 {

	public static void main(String[] args) {
		
		int su = Integer.parseInt(JOptionPane.showInputDialog("정수를 입력하세요."));
		
		if(su >= 50) {
			// 조건식이 참인 겨우 실행문
			System.out.println("입력 받은 수는 50 이상의 숫자입니다.");
		} else {
			// 조건식이 거짓인 경우 실행문
			System.out.println("입력 받은 수는 50 미만의 숫자입니다.");
		}

	}

}
