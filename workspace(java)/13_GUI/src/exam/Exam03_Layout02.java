package exam;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Exam03_Layout02 extends JFrame{

	public Exam03_Layout02() {
		
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		
		JLabel jl1 = new JLabel("수 1 : ");
		JLabel jl2 = new JLabel("수 2 : ");
		JLabel jl3 = new JLabel("연산자 :");
		
		JTextField jt1 = new JTextField(5);
		JTextField jt2 = new JTextField(5);
		
		JTextArea jta = new JTextArea(5,30);
		JScrollPane jsp = new JScrollPane(jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setLineWrap(true);
		
		JRadioButton jrb1 = new JRadioButton("+");
		JRadioButton jrb2 = new JRadioButton("-");
		JRadioButton jrb3 = new JRadioButton("/");
		JRadioButton jrb4 = new JRadioButton("*");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1); bg.add(jrb2); bg.add(jrb3); bg.add(jrb4);
		
		JButton bt1 = new JButton("계 산");
		JButton bt2 = new JButton("종 료");
		JButton bt3 = new JButton("취 소");
		
		north.add(jl1); north.add(jt1);
		north.add(jl2); north.add(jt2);
		north.add(jl3);
		north.add(jrb1); north.add(jrb2); north.add(jrb3); north.add(jrb4);
		
		center.add(jsp);
		
		south.add(bt1); south.add(bt2); south.add(bt3);

		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
		setBounds(200,200,450,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// 이벤트 처리
		// 4. 이벤트 처리
		// 계산(jb1) 버튼
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(jt1.getText());
				int num2 = Integer.parseInt(jt2.getText());
				
				String result = "";
				
				if(jrb1.isSelected()) {
					result = "결과 >>> " + num1+"+"+num2+"="+(num1+num2);
				} else if(jrb2.isSelected()) {
					result = "결과 >>> " + num1+"-"+num2+"="+(num1-num2);
				} else if(jrb3.isSelected()) {
					result = "결과 >>> " + num1+"/"+num2+"="+(num1/num2);
				} else if(jrb4.isSelected()) {
					result = "결과 >>> " + num1+"*"+num2+"="+(num1*num2);
				}
				
				jta.append(result + "\n");
				jt1.setText(""); jt2.setText("");
				
				// 마우스 커서를 해당 컴포넌트에 지정시키는 메서드
				jt1.requestFocus();
			}
		});
		
		// 종료(jb2) 버튼
		bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		
		// 취소(jb3) 버튼
		bt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				jt1.setText(""); jt2.setText("");
				jta.setText("");
				// 마우스 커서를 해당 컴포넌트에 지정시키는 메서드
				jt1.requestFocus();
				
			}
		});
	}
	
	public static void main(String[] args) {
		new Exam03_Layout02();

	}

}
