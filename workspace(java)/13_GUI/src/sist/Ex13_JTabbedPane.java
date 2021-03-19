package sist;

import java.awt.Color;

import javax.swing.*;

public class Ex13_JTabbedPane extends JFrame{

	public Ex13_JTabbedPane() {
		
		// 1. 탭의 갯수만큼 컨테이너가 만들어져야한다.
		JTabbedPane tab = new JTabbedPane();
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		// 1-1. 컨테이너마다 배경색을 다르게 지정해보자.
		jp1.setBackground(Color.ORANGE);
		jp2.setBackground(Color.GRAY);
		jp3.setBackground(Color.PINK);
		
		// 2-1-1. 첫번째 탭에 올라갈 컴포넌트를 만들어 보자.
		JButton jb1 = new JButton("버튼1");
		JButton jb2 = new JButton("버튼2");
		JButton jb3 = new JButton("버튼3");
		
		// 2-1-2. 첫번째 탭에 올려질 컴포넌트를 컨테이너(jp1)에 올려야 한다.
		jp1.add(jb1); jp1.add(jb2); jp1.add(jb3);
		
		// 2-2-1. 두번째 탭에 올라갈 컴포넌트를 만들어 보자.
		JCheckBox jcb1 = new JCheckBox("여행");
		JCheckBox jcb2 = new JCheckBox("운동");
		JCheckBox jcb3 = new JCheckBox("게임");
		JCheckBox jcb4 = new JCheckBox("잠자기");
		
		// 2-2-2. 두번째 탭에 올려질 컴포넌트를 컨테이너(jp2)에 올려야 한다.
		jp2.add(jcb1); jp2.add(jcb2); jp2.add(jcb3); jp2.add(jcb4);
		
		// 2-3-1. 세번째 탭에 올려질 컴포넌트를 만들어 보자.
		JRadioButton jrb1 = new JRadioButton("여행");
		JRadioButton jrb2 = new JRadioButton("잠자기");
		JRadioButton jrb3 = new JRadioButton("운동");
		JRadioButton jrb4 = new JRadioButton("게임");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1); bg.add(jrb2); bg.add(jrb3); bg.add(jrb4);
		
		// 2-3-2. 세번째 탭에 올려질 컴포넌트를 컨테이너(jp3)에 올려야 한다.
		jp3.add(jrb1); jp3.add(jrb2); jp3.add(jrb3); jp3.add(jrb4);
		
		// 3. 각각의 컨테이너들을 탭에 올려준다
		tab.add("버튼 탭", jp1); 
		tab.add("체크박스 탭", jp2); 
		tab.add("라디오버튼 탭", jp3);
		
		// 4. 탭을 프레임에 올려준다.
		add(tab);
		
		setBounds(200,200,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex13_JTabbedPane();

	}

}
