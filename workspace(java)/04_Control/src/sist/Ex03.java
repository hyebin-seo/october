package sist;

import javax.swing.JOptionPane;

/*
 * 키보드로 입력 받은 정수값이 5로 나누어 떨어지면
 * " 이 값은 5로 나누어집니다." 라고 출력해 보세요.
 */

public class Ex03 {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		// 1. 키보드로 입력 받는 방법 - 2번째
		int su = Integer.parseInt(JOptionPane.showInputDialog("정수를 입력하세요."));
		
		// 2. 5로 나누어서 나머지가 0인 작업
		if(su % 5 == 0){
			System.out.println("입력 받은 " + su + "(은)는 5로 나누어 떨어집니다.");
		}
		
		System.out.println("프로그램 종료");

	}

}
