package sist;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Ex07_JRadioButton extends JFrame{

	public Ex07_JRadioButton() {
		JPanel jp = new JPanel();
		setTitle("JRadioButton 예제");
		
		// 1. 컴포넌트를 만들어 보자.
		JRadioButton jrb1 = new JRadioButton("게임");
		JRadioButton jrb2 = new JRadioButton("여행", true);
		JRadioButton jrb3 = new JRadioButton("운동");
		JRadioButton jrb4 = new JRadioButton("잠자기");
		
		// 라디오 버튼은 반드시 ButtonGroup에 올려져야 한다. 안 그러면 전부 선택이 됨.
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		bg.add(jrb4);
		
		// 2. 컴포넌트를 컨테이너에 올려야 한다.
		jp.add(jrb1);
		jp.add(jrb2);
		jp.add(jrb3);
		jp.add(jrb4);

		// 3. 컨테이너를 프레임에 올려야 한다.
		add(jp);
		setBounds(100,100,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Ex07_JRadioButton();

	}

}
