package sist;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

// 프레임의 특정 위치에 마우스 버튼을 클릭하면 마우스 포인터(해당 위치)로 글자를 옮겨 보자.

public class Ex27_Event extends JFrame {
	
	public Ex27_Event() {
		
		setTitle("글자 이동 이벤트");
		JPanel jp = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자
		JLabel label = new JLabel("JAVA");
		label.setFont(new Font("굴림체", Font.BOLD, 30));
		
		// 2. 컴포넌트를 컨테이너에 올려야 한다.
		jp.add(label);
		
		// 3. 컨테이너에 프레임을 올려야 한다.
		add(jp);
		
		setBounds(200, 200, 1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// 이벤트 처리
		// 컨테이너에서 특정 영역에 마우스 클릭 시 이벤트 처리
		jp.addMouseListener(new MouseListener() {
			
			@Override // 눌려진 마우스 버튼이 떼어질 때
			public void mouseReleased(MouseEvent e) { }
			
			@Override // 마우스 버튼이 눌러질 때
			public void mousePressed(MouseEvent e) {
				int x = e.getX(); //마우스 버튼이 눌러질 때의 X좌표값
				int y = e.getY(); //마우스 버튼이 눌러질 때의 Y좌표값
				// 라벨 컴포넌트의 위치를 (x, y)좌표로 이동
				label.setLocation(x, y);
				
			}
			
			@Override // 컴포넌트 위에 올라온 마우스가 컴포넌트를 떠날 때
			public void mouseExited(MouseEvent e) { }
			
			@Override // 컴포넌트 위에 마우스가 올라왔을 때
			public void mouseEntered(MouseEvent e) { }
			
			@Override // 마우스 버튼이 클릭 될 때
			public void mouseClicked(MouseEvent e) { }
		});
	}

	public static void main(String[] args) {
		
		new Ex27_Event();

	}

}
