package sist;

import javax.swing.JOptionPane;

/*
 * [문제] 키보드로 입력받은 점수가 60점 이상이면 "합격"이라는 문자열을 화면에 출력해 보세요.
 */

public class Ex05 {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		int su = Integer.parseInt(JOptionPane.showInputDialog("점수를 입력하세요."));
		
		if(su >= 60){
			System.out.println(su + "점 합격!");
		}
		
		System.out.println("프로그램 종료");

	}

}
