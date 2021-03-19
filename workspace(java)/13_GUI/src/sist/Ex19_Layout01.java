package sist;

import java.awt.BorderLayout;

import javax.swing.*;

// 간단한 계산기 화면을 구성해보자.

public class Ex19_Layout01 extends JFrame{

	public Ex19_Layout01() {
		setTitle("간단한 계산기 예제");
		
		JPanel north = new JPanel(); // 상단 컨테이너
		JPanel center = new JPanel(); // 중앙 컨테이너
		JPanel south = new JPanel(); // 하단 컨테이너
		
		// 1. 컴포넌트를 만들어 보자.
		// 1-1. north(상단)에 들어갈 컴포넌트를 만들자.
		JLabel jl1 = new JLabel("수 1 : ");
		JTextField su1 = new JTextField(5);
		
		JLabel jl2 = new JLabel("수 2 : ");
		JTextField su2 = new JTextField(5);
		
		JLabel jl3 = new JLabel("연산자 : ");
		JTextField op = new JTextField(1);
		
		// 1-2. center(중앙)에 들어갈 컴포넌트를 만들자.
		JTextArea jta = new JTextArea(5, 20);
		JScrollPane jsp = new JScrollPane(jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		// 자동 줄바꿈 기능
		jta.setLineWrap(true); // 자동 줄바꿈 기능
		
		// 1-3. south(하단)에 들어갈 컴포넌트를 만들자
		JButton jb1 = new JButton("계 산");
		JButton jb2 = new JButton("종 료");
		JButton jb3 = new JButton("취 소");
		
		// 2. 컴포넌트를 컨테이너에 올려야 한다.
		// 2-1. jp(north) 컨테이너에 1-1 컴포넌트들을 올려준다.
		north.add(jl1); north.add(su1);
		north.add(jl2); north.add(su2); 
		north.add(jl3); north.add(op);
		
		// 2-2. center 컨테이너에 1-2 컴포넌트들을 올려준다.
		center.add(jsp);
		
		// 2-3. south 컨테이너에 1-3 컴포넌트들을 올려준다.
		south.add(jb1); south.add(jb2); south.add(jb3);
		
		// 3. 3개의 컨테이너를 프레임에 올리되, 배치해서 올리자.
		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
		setBounds(200,200,350,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Ex19_Layout01();

	}

}
