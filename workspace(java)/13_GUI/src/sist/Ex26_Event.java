package sist;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex26_Event extends JFrame {
	
	JLabel result;
	
	public Ex26_Event() {
		setTitle("이벤트 테스트");
		
		JPanel panel = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자.
		JButton male = new JButton("남자");
		JButton female = new JButton("여자");
		JLabel label = new JLabel("당신의 성별은 ?");
		result = new JLabel(""); // 결과가 출력될 컴포넌트
		result.setForeground(new Color(219,85,0));
		
		// 2. 컴포넌트를 컨테이너에 올려야한다.
		panel.add(male); panel.add(female);
		panel.add(label); panel.add(result);
		
		// 3. 컨테이너를 프레임에 올린다.
		add(panel);
		
		setBounds(200,200,300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// 4. 이벤트 처리
		// 이벤트 처리 시 무명클래스를 이용하여 이벤트 처리
		// 남자라는 버튼을 클릭했을 때 이벤트 처리
		male.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setText(e.getActionCommand());
				
			}
		});
		
		// 여자라는 버튼을 클릭했을 떄 이벤트 처리
		female.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setText(e.getActionCommand());
				
			}
		});
		
		
	}

	public static void main(String[] args) {
		new Ex26_Event();
	}

}
