package sist;

import javax.swing.*;

public class Ex15_ETC extends JFrame{

	public Ex15_ETC() {
		
		setTitle("기타예제");
		
		JPanel jp = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자.
		JLabel jl1 = new JLabel("아이디 : ");
		JTextField id = new JTextField(10);
		
		JLabel jl2 = new JLabel("비밀번호 : ");
		JPasswordField pwd = new JPasswordField(10);
		
		JLabel jl3 = new JLabel("하고 싶은 말 : ");
		JTextArea jta = new JTextArea(5, 30);
		
		JScrollPane jsp = new JScrollPane(
				jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		// TextArea 컴포넌트에서 자동 줄바꿈 기능 제공 메서드
		jta.setLineWrap(true);
		
		// 2. 컴포넌트를 컨테이너에 올리기
		jp.add(jl1); jp.add(id);
		jp.add(jl2); jp.add(pwd);
		jp.add(jl3); jp.add(jsp); // ScrollPane이 적용된 컴포넌트는 Pane을 올린다.

		// 3. 컨테이너를 프레임에 올리기
		add(jp);
		
		setBounds(100,100,250,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Ex15_ETC();

	}

}
