package sist;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex34_Event extends JFrame {

	public Ex34_Event() {
	
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
		
		// 4. 이벤트 처리
		// 계산(jb1) 버튼을 클릭 시 이벤트 처리
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String irum = name.getText();
				int korea = Integer.parseInt(kor.getText());
				int english = Integer.parseInt(eng.getText());
				int math = Integer.parseInt(mat.getText());
				
				// 총점 구하기
				int total = korea + english + math;
				
				// 평균 구하기
				double avg = total / 3.0;
				
				// 학점 구하기
				String grade = null;
				
				if(avg >= 90) {
					grade = "A학점";
				}else if(avg >= 80) {
					grade = "B학점";
				}else if(avg >= 70) {
					grade = "C학점";
				}else if(avg >= 60) {
					grade = "D학점";
				}else {
					grade = "F학점";
				}
				
				// JTextArea 영역에 성적 결과를 출력해 보자.
				jta.append("*** "+irum+"님 성적 결과 ***\n");
				jta.append("이     름 : "+irum+"\n");
				jta.append("국어점수 : "+korea+"점\n");
				jta.append("영어점수 : "+english+"점\n");
				jta.append("수학점수 : "+math+"점\n");
				jta.append("총     점 : "+total+"점\n");
				jta.append("평     균 : "+String.format("%.2f점", avg)+"\n");
				jta.append("학     점 : "+grade+"\n");
			
				// 각각의 컴포넌트 초기화 작업
				name.setText(null); kor.setText(null);
				eng.setText(null); mat.setText(null);
				
				name.requestFocus();
			}
		});
		
		// 종료(jb2) 버튼을 클릭 시 이벤트 처리
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		
		// 취소(jb3) 버튼을 클릭 시 이벤트 처리
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 각각의 컴포넌트 초기화 작업
				name.setText(null); kor.setText(null);
				eng.setText(null); mat.setText(null);
				jta.setText(null);
				
				name.requestFocus();
				
			}
		});
	}
	
	
	public static void main(String[] args) {
		
		new Ex34_Event();
		
	}

}
