package sist;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * 다이얼로그
 * - 다이얼로그는 보여주고자 하는 내용을 스크린에 출력을 하고, 사용자로부터 입력을 받는 대화상자.
 * 
 * 팝업 다이얼로그
 * - 사용자에게 메세지를 전달하거나 간단한 문자열을 입력 받는 유용한 다이얼로그.
 * 1) 입력 다이얼로그 : JOptionPane.showInputDialog()
 *                 ==> 한 줄 문자열을 입력 받는 다이얼로그.
 * 2) 확인 다이얼로그 : JOptionPane.showConfirmDialog()
 *                 ==> 사용자로부터 확인 / 취소를 입력 받는 다이얼로그.
 * 3) 메세지 다이얼로그 : JOptionPane.showMessageDialog()
 *                  ==> 사용자에게 문자열 메세지를 출력 하기 위한 다이얼로그
 */

public class Ex30_Event extends JFrame{

	public Ex30_Event() {
		setTitle("다이얼로그 예제");
		JPanel jp = new JPanel();
		JButton inputBtn = new JButton("Input Name");
		JButton cofirmBtn = new JButton("Confirm");
		JButton messageBtn = new JButton("Message");
		JTextField jtf = new JTextField(15);
		
		jp.add(inputBtn); jp.add(cofirmBtn);
		jp.add(messageBtn); jp.add(jtf);
		
		add(jp, BorderLayout.NORTH);
		
		setBounds(200, 200, 500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// 4.이벤트 처리
		inputBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = JOptionPane.showInputDialog("이름을 입력하세요.");
				if(name != null) {
					// 사용자가 입력한 문자열을 텍스트 필드 창에 출력하는 메서드
					jtf.setText(name);
				}
			}
		});
		
		cofirmBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 첫번쨰 매개변수는 창이 떠오를 위치를 선정한다.
				// 컴포넌트 위(컴포넌트명)or화면중앙(null)
				int result = JOptionPane.showConfirmDialog(cofirmBtn, "계속 하실 건가요?",
						"Confirm", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.CLOSED_OPTION) {
					jtf.setText("Just Closed Without Selection");
				} else if(result == JOptionPane.YES_OPTION) {
					jtf.setText("Yes");
				} else {
					jtf.setText("NO");
				}

			}
		});
		
		messageBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "조심하세요!!!",
						"Message", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		
	}
	
	public static void main(String[] args) {
		new Ex30_Event();
	}

}
