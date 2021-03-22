package exam;

import java.awt.BorderLayout;

import javax.swing.*;

public class Exam01 extends JFrame{

	public Exam01() {
		
		JPanel north_1 = new JPanel();
		JPanel north_2 = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		
		JLabel jl1 = new JLabel("이 름 : ");
		JLabel jl2 = new JLabel("국 어 : ");
		JLabel jl3 = new JLabel("영 어 : ");
		JLabel jl4 = new JLabel("수 학 : ");
		
		JTextField jt1 = new JTextField(10);
		JTextField jt2 = new JTextField(5);
		JTextField jt3 = new JTextField(5);
		JTextField jt4 = new JTextField(5);
		
		JTextArea jta = new JTextArea(10,30);
		JScrollPane jsp = new JScrollPane(jta,
		ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setLineWrap(true);
		
		JButton bt1 = new JButton("계 산");
		JButton bt2 = new JButton("종 료");
		JButton bt3 = new JButton("취 소");
		
		north_1.add(jl1); north_1.add(jt1);

		south.add(bt1); south.add(bt2); south.add(bt3);
		
		center.add(jsp);
		
		JPanel pg = new JPanel(new BorderLayout());
		
		north_2.add(jl2); north_2.add(jt2);
		north_2.add(jl3); north_2.add(jt3);
		north_2.add(jl4); north_2.add(jt4);

		pg.add(north_2, BorderLayout.NORTH);
		pg.add(center, BorderLayout.CENTER);
		pg.add(south, BorderLayout.SOUTH);
		
		add(north_1, BorderLayout.NORTH);
		add(pg, BorderLayout.CENTER);
		
		setBounds(200,200,450,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Exam01();

	}

}
