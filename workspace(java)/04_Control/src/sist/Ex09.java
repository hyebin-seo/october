package sist;

import javax.swing.JOptionPane;

/* 
 * 키보드로 두 수를 입력 받아서 그 중에 큰 정수를 화면에 출력해보세요.
 */

public class Ex09 {

	public static void main(String[] args) {
		
		// 1. 키보드로부터 두 수를 입력받는다.
		int su1 = Integer.parseInt(JOptionPane.showInputDialog("첫 번째 수를 입력하세요."));
		int su2 = Integer.parseInt(JOptionPane.showInputDialog("두 번째 수를 입력하세요."));

		int max; // 최대값 변수
		
		if(su1 > su2) {
			max = su1;
		} else {
			max = su2;
		}
		
		System.out.println("최대값은 " + max + "입니다.");
	}

}
