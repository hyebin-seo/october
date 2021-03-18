package sist;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex04_JButton extends JFrame{

	public Ex04_JButton() {
		
		
		
		// 프레임을 만들어 보자.
		JFrame frame = new JFrame();
		
		// 컨테이너를 만들어 보자
		JPanel jp = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자.
		JButton jb1 = new JButton("버튼1"); 
		JButton jb2 = new JButton("버튼2"); 
		JButton jb3 = new JButton("버튼3"); 
		
		// 2. 컴포넌트를 컨테이너에 올려야 한다.
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		
		// 3. 컨테이너를 프레임에 올려야 한다.
		frame.add(jp);
		
		// add(jp);
		frame.setTitle("세번째 예제");
		frame.setBounds(100, 100, 300, 300);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Ex04_JButton();
	}

}
