package sist;

import javax.swing.JOptionPane;

/*
 * [문제] 키보드로 입력 받은 정수값을 5로 나누어서 0으로 떨어지면
 * "이 값은 5로 나누어집니다."라고 출력을 하고, 그렇지 않으면
 * "이 값은 5로 나누어지지 않습니다."라고 화면에 출력해 보세요.
 * 단, 음수값이 입력이 되면 "음수 값이 입력되었습니다." 라고 출력.
 */

public class Ex08 {

	public static void main(String[] args) {
		
		int su = Integer.parseInt(JOptionPane.showInputDialog("정수를 입력하세요."));
		
		if(su < 0) { // 음수인 경우
			
			System.out.println(su + " 음수 값이 입력되었습니다.");
			
		} else { // 양수인 경우
			
			if(su % 5 == 0) {
				System.out.println(su + "(은)는 5로 나누어집니다.");
			} else {
				System.out.println(su + "(은)는 5로 나누어지지 않습니다.");
			}
			
		}
		

	}

}
