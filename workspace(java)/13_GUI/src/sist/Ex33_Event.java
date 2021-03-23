package sist;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex33_Event extends JFrame {

	public Ex33_Event() {
	
		setTitle("계산기 예제 - 2");
		
		JPanel north = new JPanel();
		JPanel south = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자.
		// 1-1. north 컨테이너에 들어갈 컴포넌트를 만들자.
		JLabel jl1 = new JLabel("수 1 : ");
		JTextField su1 = new JTextField(5);
		
		JLabel jl2 = new JLabel("수 2 : ");
		JTextField su2 = new JTextField(5);
		
		JLabel jl3 = new JLabel("연산자 : ");
		
		JRadioButton jrb1 = new JRadioButton("+");
		JRadioButton jrb2 = new JRadioButton("-");
		JRadioButton jrb3 = new JRadioButton("*");
		JRadioButton jrb4 = new JRadioButton("/");
		JRadioButton jrb5 = new JRadioButton("%");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1); bg.add(jrb2);
		bg.add(jrb3); bg.add(jrb4); bg.add(jrb5);
		
		// 1-2. 가운데 들어갈 컴포넌트를 만들자.
		JTextArea jta = new JTextArea(5, 25);
		
		JScrollPane jsp = new JScrollPane(
				jta, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		jta.setLineWrap(true);
				
		// 1-3. south 컨테이너에 들어갈 컴포넌트를 만들자.
		JButton jb1 = new JButton("계  산");
		JButton jb2 = new JButton("종  료");
		JButton jb3 = new JButton("취  소");
		
		
		// 2. 컴포넌트를 컨테이너에 올려주어야 한다.
		// 2-1. north 컨테이너에 1-1 컴포넌트들을 올려 주자.
		north.add(jl1); north.add(su1);
		north.add(jl2); north.add(su2);
		north.add(jl3); north.add(jrb1);
		north.add(jrb2); north.add(jrb3);
		north.add(jrb4); north.add(jrb5);
		
		// 2-2. south 컨테이너에 2-3 컴포넌트들을 올려 주자.
		south.add(jb1); south.add(jb2); south.add(jb3);
		
		
		// 3. 컨테이너를 프레임에 올려주어야 한다.
		add(north, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
		setBounds(200, 200, 450, 200);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		// 4. 이벤트 처리
		// 계산(jb1) 버튼을 클릭했을 때 이벤트 처리
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(su1.getText());
				int num2 = Integer.parseInt(su2.getText());
				
				String result = null;
				
				if(jrb1.isSelected()) {
					result = "결과 >>> "+num1+" + "+num2+" = "+(num1+num2);
				}else if(jrb2.isSelected()) {
					result = "결과 >>> "+num1+" - "+num2+" = "+(num1-num2);
				}else if(jrb3.isSelected()) {
					result = "결과 >>> "+num1+" * "+num2+" = "+(num1*num2);
				}else if(jrb4.isSelected()) {
					result = "결과 >>> "+num1+" / "+num2+" = "+(num1/num2);
				}else if(jrb5.isSelected()) {
					result = "결과 >>> "+num1+" % "+num2+" = "+(num1%num2);
				}
				
				jta.append(result + "\n");
				
				// 입력받은 컴포넌트들은 초기화 해 주자.
				su1.setText(null); su2.setText(null);
				// 라디오버튼도 초기화가 되어야 한다.
				bg.clearSelection();
				
				su1.requestFocus();
			}
		});
		
		// 종료(jb2) 버튼을 클릭했을 때 이벤트 처리
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		
		// 취소(jb3) 버튼을 클릭했을 때 이벤트 처리
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 입력받은 컴포넌트들은 초기화 해 주자.
				su1.setText(null); su2.setText(null);
				// 라디오버튼도 초기화가 되어야 한다.
				bg.clearSelection();
				
				su1.requestFocus();
				
			}
		});
	}
	
	public static void main(String[] args) {
		
		new Ex33_Event();

	}

}
