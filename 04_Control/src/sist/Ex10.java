package sist;

import javax.swing.JOptionPane;

/*
 * 키보드로 두 수를 입력 받아서 두 수의 차이를 화면에 출력해 보세요.
 */

public class Ex10 {

	public static void main(String[] args) {
		
		// 1. 키보드로부터 두 수를 입력받는다.
		int su1 = Integer.parseInt(JOptionPane.showInputDialog("첫 번째 수를 입력하세요."));
		int su2 = Integer.parseInt(JOptionPane.showInputDialog("두 번째 수를 입력하세요."));

		int dist; // 거리값 변수
		
		if(su1 > su2) {
			dist = su1 - su2;
		} else {
			dist = su2 - su1;
		}
		
		System.out.println("두 수의 차이는 " + dist + "입니다.");
				

	}

}
