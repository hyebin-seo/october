package sist;

import javax.swing.*;

public class Ex10_JList extends JFrame{

	public Ex10_JList() {
		
		setTitle("JList 예제");
		JPanel jp = new JPanel();
		
		// 1. 컴포넌트를 만들어보자.
		String[] job = {"회사원", "공무원", "학생", "주부", "무직"};
		
		JList<String> list = new JList<String>(job);
		
		// 2. 컴포넌트를 컨테이너에 올리자.
		jp.add(list);
		
		// 3. 컨테이너는 프레임에 올려야 한다.
		add(jp);
		
		setBounds(100,100,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		 new Ex10_JList();

	}

}
