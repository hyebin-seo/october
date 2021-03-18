package sist;

import javax.swing.JFrame;

public class Ex03_JFrame extends JFrame{

	public Ex03_JFrame() {
		
		setTitle("세번째 예제");
		setBounds(100, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Ex03_JFrame();

	}

}
