package sist;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

// F1 키를 입력을 받으면 배경색을 파란색으로 변경하고,
// ESC 키를 입력 받으면 배경색을 노란색으로 변경해 보자.

public class Ex28_Event extends JFrame{

	public Ex28_Event() {
		setTitle("키이벤트처리");
		JPanel jp = new JPanel();
		
		//1. 컴포넌트를 만들어보자
		JLabel label = new JLabel();
		
		// 2. 컴포넌트를 컨테이너에 올려야 한다.
		jp.add(label);
		
		// 3. 컨테이너에 프레임을 올려야 한다.
		add(jp);
		
		// 키보드 입력 받는 이벤트 처리할 떄 반드시 써줘야하는 메서드
		jp.setFocusable(true);
		
		setBounds(200, 200, 1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// 4. 이벤트 처리
		jp.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) { }
			
			@Override
			public void keyReleased(KeyEvent e) {
				String str = KeyEvent.getKeyText(e.getKeyCode());
				label.setText(str + "키가 입력되었습니다.");
				
				if(e.getKeyCode() == KeyEvent.VK_F1) {
					jp.setBackground(Color.blue);
				} else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					jp.setBackground(Color.YELLOW);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) { }
		});
	}
	
	public static void main(String[] args) {
		
		new Ex28_Event();

	}

}
