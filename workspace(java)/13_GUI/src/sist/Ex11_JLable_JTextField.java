package sist;

import javax.swing.*;

public class Ex11_JLable_JTextField extends JFrame{

	public Ex11_JLable_JTextField() {
		setTitle("JLable&JTextField 예제");
		JPanel jp = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자.
		JLabel jl1 = new JLabel("이 름 : ");
		JTextField name = new JTextField(15);
		
		JLabel jl2 = new JLabel("학 과 : ");
		JTextField major = new JTextField(15);
		
		JLabel jl3 = new JLabel("주 소 : ");
		JTextField addr = new JTextField(15);
		
		// 2. 컴포넌트를 컨테이너에 올려야 한다.
		jp.add(jl1);  jp.add(name);
		jp.add(jl2);  jp.add(major);
		jp.add(jl3);  jp.add(addr);
		
		// 3. 컨테이너는 프레임에 올려야 한다.
		add(jp);
		
		setBounds(100,100,250,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new Ex11_JLable_JTextField();
	}

}
