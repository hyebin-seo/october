package sist;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex06_JCheckBoxExam {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		jf.setTitle("과일 체크박스 예제");
		
		// 1-1. 과일 이미지 아이콘을 만들어보자.
		ImageIcon kiwi = new ImageIcon("images/kiwi.jpg");
		ImageIcon mango = new ImageIcon("images/mango.jpg");
		ImageIcon apple = new ImageIcon("images/apple.jpg");
		
		// 1-2. 컴포넌트를 만들어 보자.
		JCheckBoxMenuItem jcb1 = new JCheckBoxMenuItem("키위", kiwi);
		JCheckBoxMenuItem jcb2 = new JCheckBoxMenuItem("망고", mango);
		JCheckBoxMenuItem jcb3 = new JCheckBoxMenuItem("사과", apple);
		
		// 2. 컴포넌트를 컨테이너에 올려야 한다.
		jp.add(jcb1); jp.add(jcb2); jp.add(jcb3);
		
		// 3. 컨테이너를 프레임에 올려야 한다.
		jf.add(jp);
		
		jf.setBounds(100,100,300,600);
		
		// 프레임의 크기를 안에 들은 컴포넌트에 따라 자동으로 맞춰주는 메서드
		jf.pack();
		
		// 프레임의 크기 조절을 off
		jf.setResizable(false);
		
		// 프레임의 x버튼 클릭 시 종료시키는 메서드
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);

	}

}
