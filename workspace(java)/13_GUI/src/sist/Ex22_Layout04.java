package sist;

import java.awt.BorderLayout;

import javax.swing.*;

// 성적 처리 화면을 만들어 보자.

public class Ex22_Layout04 extends JFrame {

	public Ex22_Layout04() {
	
		setTitle("성적 처리");
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자.
		// 1-1. North(이름)에 들어갈 컴포넌트를 만들어 보자.
		JLabel jl1 = new JLabel("이   름 : ");
		JTextField name = new JTextField(10);
		
		// 1-2. North(과목점수)에 들어갈 컴포넌트를 만들어 보자.
		JLabel jl2 = new JLabel("국  어 : ");
		JTextField kor = new JTextField(3);
		
		JLabel jl3 = new JLabel("영  어 : ");
		JTextField eng = new JTextField(3);
		
		JLabel jl4 = new JLabel("수  학 : ");
		JTextField mat = new JTextField(3);
		
		// 1-3. TextArea 컴포넌트를 만들어 보자.
		JTextArea jta = new JTextArea(5, 30);
		JScrollPane jsp = new JScrollPane(
				jta, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setLineWrap(true);
		
		// 1-4. South(버튼)에 들어갈 컴포넌트를 만들어 보자.
		JButton jb1 = new JButton("계  산");
		JButton jb2 = new JButton("종  료");
		JButton jb3 = new JButton("취  소");
		
		
		// 2. 컴포넌트를 컨테이너에 올려야 한다.
		// 2-1. 1-1 컴포넌트들을 jp1 컨테이너에 올려야 한다.
		jp1.add(jl1); jp1.add(name);
		
		// 2-2. 1-2 컴포넌트들을 jp2 컨테이너에 올려야 한다.
		jp2.add(jl2); jp2.add(kor);
		jp2.add(jl3); jp2.add(eng);
		jp2.add(jl4); jp2.add(mat);
		
		// 2-3. 1-4 컴포넌트들을 jp3 컨테이너에 올려야 한다.
		jp3.add(jb1); jp3.add(jb2); jp3.add(jb3);
		
		
		// 새로운 컨테이너를 만들어서 기존의 컨테이너들을 올리자.
		JPanel pg = new JPanel(new BorderLayout());
		
		pg.add(jp2, BorderLayout.NORTH);
		pg.add(jsp, BorderLayout.CENTER);
		pg.add(jp3, BorderLayout.SOUTH);
		
		
		// 3. 컨테이너를 프레임에 올려야 한다.
		add(jp1, BorderLayout.NORTH);
		add(pg, BorderLayout.CENTER);
		
		
		setBounds(200, 200, 300, 300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
				
		
	}
	
	public static void main(String[] args) {
		
		new Ex22_Layout04();

	}

}
