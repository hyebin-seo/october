package sist;

import javax.swing.*;

// 한 번 누르면 선택되었다가 다시 누르면 선택이 해제 되는 버튼
public class Ex08_JToggleButton extends JFrame{

	public Ex08_JToggleButton() {
		
		JPanel jp = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자.
		JToggleButton jtb1 = new JToggleButton("토글버튼1");
		JToggleButton jtb2 = new JToggleButton("토글버튼2");
		JToggleButton jtb3 = new JToggleButton("토글버튼3");
		
		// 2. 컴포넌트는 컨테이너에 올려야 한다.
		jp.add(jtb1);
		jp.add(jtb2);
		jp.add(jtb3);
		
		// 3. 컨테이너는 프레임에 올려져야 한다.
		add(jp);
		setBounds(100,100,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Ex08_JToggleButton();

	}

}
