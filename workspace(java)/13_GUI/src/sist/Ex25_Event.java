package sist;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex25_Event extends JFrame{

	public Ex25_Event() {
		setTitle("버튼 이벤트");
		
		JPanel panel = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자.
		JButton button = new JButton("java");
		
		// 이벤트 처리 방법 - 두번째
		// 이벤트 관련하여 독립된 클래스를 생성하여 처리하는 방법.
		Mybutton listener = new Mybutton();
		button.addActionListener(listener);

		panel.add(button);
		
		// 3. 컨테이너를 프레임에 올린다.
		add(panel);

		
		setBounds(200,200,300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Ex25_Event();

	}

}
// 독립된 클래스를 선언하여 이벤트 처리
class Mybutton implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// 컴포넌트의 정보를 반환해주는 메서드
		JButton button = (JButton)e.getSource();
		
		if(button.getText().equals("java")) {
			button.setText("자바");
		} else {
			button.setText("java");
		}
		
	}
	
}
