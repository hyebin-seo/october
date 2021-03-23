package sist;

import java.awt.BorderLayout;

import javax.swing.*;

// 커피 자판기 화면 예제

public class Ex23_Layout05 extends JFrame {

	public Ex23_Layout05() {
	
		setTitle("커피 자판기");
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자.
		// 1-1. jp1 컨테이너에 들어갈 컴포넌트를 만들어 보자.
		JLabel jl1 = new JLabel("원하는 커피 선택");
		
		// 1-2. jp2 컨테이너에 들어갈 컴포넌트를 만들어 보자.
		JRadioButton jrb1 = new JRadioButton("아메리카노(2500)");
		JRadioButton jrb2 = new JRadioButton("카페모카(3500)");
		JRadioButton jrb3 = new JRadioButton("에스프레소(2500)");
		JRadioButton jrb4 = new JRadioButton("카페라떼(4000)");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1); bg.add(jrb2);
		bg.add(jrb3); bg.add(jrb4);
		
		// 1-3. jp3 컨테이너에 들어갈 컴포넌트를 만들어 보자.
		JLabel jl2 = new JLabel("수   량 : ");
		JTextField su = new JTextField(5);
		
		JLabel jl3 = new JLabel("입금액 : ");
		JTextField money = new JTextField(10);
		
		// 1-4. JTextArea 컴포넌트를 만들어 보자.
		JTextArea jta = new JTextArea(5, 30);
		JScrollPane jsp = new JScrollPane(
				jta, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setLineWrap(true);
		
		// 1-5. jp4 컨테이너에 들어갈 컴포넌트를 만들어 보자.
		JButton jb1 = new JButton("계   산");
		JButton jb2 = new JButton("종   료");
		JButton jb3 = new JButton("취   소");
		
		
		// 2. 컴포넌트는 컨테이너에 올려져야 한다.
		// 2-1. 1-1 컴포넌트들을 jp1 컨테이너에 올려야 한다.
		jp1.add(jl1);
		
		// 2-2. 1-2 컴포넌트들을 jp2 컨테이너에 올려야 한다.
		jp2.add(jrb1); jp2.add(jrb2);
		jp2.add(jrb3); jp2.add(jrb4);
		
		// 2-3. 1-3 컴포넌트들을 jp3 컨테이너에 올려야 한다.
		jp3.add(jl2); jp3.add(su);
		jp3.add(jl3); jp3.add(money);
		
		// 2-4. 1-4 컴포넌트들을 jp4 컨테이너에 올려야 한다.
		jp4.add(jb1); jp4.add(jb2); jp4.add(jb3);
		
		
		// 새로운 컨테이너를 두 개를 더 만들자.
		JPanel pg1 = new JPanel(new BorderLayout());
		JPanel pg2 = new JPanel(new BorderLayout());
		
		// pg1 컨테이너에는 jp1, jp2 컨테이너를 추가해 주자.
		pg1.add(jp1, BorderLayout.NORTH);
		pg1.add(jp2, BorderLayout.CENTER);
		
		// pg2 컨테이너에는 jp3, jsp, jp4 컨테이너를 추가해 주자.
		pg2.add(jp3, BorderLayout.NORTH);
		pg2.add(jsp, BorderLayout.CENTER);
		pg2.add(jp4, BorderLayout.SOUTH);
		
		
		// 3. 컨테이너를 프레임에 올려 주어야 한다.
		add(pg1, BorderLayout.NORTH);
		add(pg2, BorderLayout.CENTER);
		
		
		setBounds(200, 200, 300, 300);
		
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		
		new Ex23_Layout05();

	}

}
