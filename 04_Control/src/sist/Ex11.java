package sist;

import java.util.Scanner;

//import javax.swing.JOptionPane;

/*
 * [문제] 키보드로 점수를 입력받아서 입력받은 점수가 60점 이상이면 "합격"이라는 문자열을 화면에 출력하고,
 * 그렇지 않으면 "불합격" 이라는 문자열을 화면에 출력해 보세요.
 */

public class Ex11 {

	public static void main(String[] args) {
		
//		int num = Integer.parseInt(JOptionPane.showInputDialog("점수를 입력하세요."));
//		
//		if(num >= 60) {
//			System.out.println(num + "점으로 합격입니다.");
//		} else {
//			System.out.println(num + "점으로 불합격입니다.");
//		}
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 키보드로부터 정수를 입력 받는다.
		System.out.print("점수를 입력하세요 : ");
		int su = sc.nextInt(); // 키보드로부터 정수값을 입력받는 메서드
		
		if(su >= 60) {
			System.out.println(su + "점으로 합격입니다.");
		} else {
			System.out.println(su + "점으로 불합격입니다.");
		}
		
		sc.close();

	}

}
