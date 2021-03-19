package sist;

import java.awt.BorderLayout;

import javax.swing.*;

/*
 * 2.BorderLayout 배치관리자
 *   - 배치 : 동쪽, 서쪽, 남쪽, 북쪽, 중앙
 */

public class Ex17_BorderLayout extends JFrame{
	
	public Ex17_BorderLayout() {
		JPanel jp = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자
		JButton jb1 = new JButton("North");
		JButton jb2 = new JButton("South");
		JButton jb3 = new JButton("East");
		JButton jb4 = new JButton("West");
		JButton jb5 = new JButton("Center");
		
		// 2. 컴포넌트를 컨테이너에 올려야 한다.
		// 형식) new BorderLayout()
		//      new BorderLayout(수평간격, 수직간격)
		//      수평 간격 : 좌우 컴포넌트 사이의 간격. 픽셀단위. 기본값은 0
		//      수직 간격 : 상하 컴포넌트 사이의 간격. 픽셀단위. 기본값은 0
		jp.setLayout(new BorderLayout(20,30));
		
		jp.add(jb1, BorderLayout.NORTH);
		jp.add(jb2, BorderLayout.SOUTH);
		jp.add(jb3, BorderLayout.EAST);
		jp.add(jb4, BorderLayout.WEST);
		jp.add(jb5, BorderLayout.CENTER);
		
		// 3. 컨테이너를 프레임에 올려야한다.
		add(jp);
		
		setBounds(200,200,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex17_BorderLayout();

	}

}
