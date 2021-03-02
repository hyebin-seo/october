package sist;

import javax.swing.JOptionPane;

/*
 * [문제] 키보드로 입력 받은 정수값이 음수이면 "입력 받은 숫자는 음수입니다." 라고 화면에 출력해 보세요.
 */

public class Ex04 {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		// 1. 키보드로부터 정수를 입력 받자.
		int su = Integer.parseInt(JOptionPane.showInputDialog("정수를 입력하세요."));
		
		// 2. 입력 받은 정수가 음수인지 조건으로 판별하자.
		if(su < 0){
			System.out.println("입력 받은 " + su + "(은)는 음수입니다.");
		}
		
		System.out.println("프로그램 종료");

	}

}
