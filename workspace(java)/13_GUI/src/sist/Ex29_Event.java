package sist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex29_Event extends JFrame{
	
	public Ex29_Event() {
		setTitle("텍스트 영역 이벤트");
		
		JPanel panel = new JPanel();
		
		//1. 컴포넌트를 만들어보자
		JLabel j1 = new JLabel("입력 후 <Enter> 키를 입력하세요...");
		JTextField text = new JTextField(25);
		JTextArea jta = new JTextArea(5,30);
		JScrollPane jsp = new JScrollPane(
				jta, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setLineWrap(true);
		
		// 2. 컴포넌트를 컨테이너에 올려야 한다.
		panel.add(j1); panel.add(text); panel.add(jsp);
		
		// 3. 컨테이너에 프레임을 올려야 한다.
		add(panel);
		
		// 키보드 입력 받는 이벤트 처리할 떄 반드시 써줘야하는 메서드
		panel.setFocusable(true);
		
		setBounds(200, 200, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// 4. 이벤트 처리
		text.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String str = text.getText();
				jta.append(str + "\n");
				text.setText("");
				
			}
		});
	}

	public static void main(String[] args) {
		
		new Ex29_Event();
	}

}
