package sist;

import java.util.Scanner;

//import javax.swing.JOptionPane;

/*
 * [문제] 키보드로 입력받은 숫자가 홀수인지 짝수인지 판별해 보세요.
 */

public class Ex12 {

	public static void main(String[] args) {
		
//		int num = Integer.parseInt(JOptionPane.showInputDialog("점수를 입력하세요."));
//		
//		if(num % 2 == 0) {
//			System.out.println(num + "(은)는 짝수입니다.");
//		} else {
//			System.out.println(num + "(은)는 홀수입니다.");
//		}
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 키보드로부터 정수를 입력 받는다.
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt(); 
		
		if(num % 2 == 0) {
			System.out.println(num + "(은)는 짝수입니다.");
		} else {
			System.out.println(num + "(은)는 홀수입니다.");
		}
		
		sc.close();


	}

}
