package sist;

import java.awt.Frame;

/*
 * Frame을 만드는 방법 2번째
 * - Frame이라는 클래스의 객체를 생성해서 사용.
 */

public class Ex02_Frame {

	public static void main(String[] args) {
		
		Frame f = new Frame("두번째 예제");
		
		//프레임의 위치
		//f.setLocation(100, 100);
		
		//프레임의 크기
		// f.setSize(300, 300);
		
		//프레임의 위치 + 프레임의 크기 동시 설정
		f.setBounds(100, 100, 300, 300); // x좌표, y좌표, 가로, 세로
		
		//프레임을 화면에 보여주기
		f.setVisible(true);

	}

}
