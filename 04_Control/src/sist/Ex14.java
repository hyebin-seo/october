package sist;

import javax.swing.JOptionPane;

public class Ex14 {

	public static void main(String[] args) {
		
		int jumsu = Integer.parseInt
				(JOptionPane.showInputDialog("점수를 입력하세요."));
		
		if(jumsu >= 90) {
			if(jumsu >= 95) {
				System.out.println("A+학점입니다.");
			} else {
				System.out.println("A학점입니다.");
			}
		} else if(jumsu >= 80 && jumsu < 90) {
			System.out.println("B학점입니다.");
		} else if (jumsu >= 70) {
			System.out.println("C학점입니다.");
		} else if (jumsu >= 60) {
			System.out.println("D학점입니다.");
		} else {
			System.out.println("F학점입니다.");
		}

	}

}
