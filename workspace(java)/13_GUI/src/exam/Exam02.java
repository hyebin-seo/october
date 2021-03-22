package exam;

import java.awt.BorderLayout;

import javax.swing.*;

public class Exam02 extends JFrame {

	public Exam02() {
	
		setTitle("계산기 예제 - 3");
		
		JPanel north_1 = new JPanel();
		JPanel north_2 = new JPanel();
		JPanel north_3 = new JPanel();
		JPanel south = new JPanel();
		
		JLabel jl1 = new JLabel("원하는 커피 선택");

		JRadioButton jrb1 = new JRadioButton("아메리카노(2500)");
		JRadioButton jrb2 = new JRadioButton("카페모카(3500)");
		JRadioButton jrb3 = new JRadioButton("에스프레소(2500)");
		JRadioButton jrb4 = new JRadioButton("카페라떼(4000)");
		
		JLabel jl2 = new JLabel("수 량: ");
		JTextField su2 = new JTextField(10);
		
		JLabel jl3 = new JLabel("입금액: ");
		JTextField su3 = new JTextField(10);

		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1); bg.add(jrb2);
		bg.add(jrb3); bg.add(jrb4);

		JTextArea jta = new JTextArea(5, 25);
		JScrollPane jsp = new JScrollPane(
				jta, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		jta.setLineWrap(true);

		JButton jb1 = new JButton("계   산");
		JButton jb2 = new JButton("종   료");
		JButton jb3 = new JButton("취   소");

		north_1.add(jl1);
		
		north_2.add(jrb1); north_2.add(jrb2);
		north_2.add(jrb3); north_2.add(jrb4);

		north_3.add(jl2); north_3.add(su2);
		north_3.add(jl3); north_3.add(su3);

		south.add(jb1); south.add(jb2); south.add(jb3);

		JPanel pg = new JPanel(new BorderLayout());

		pg.add(north_1, BorderLayout.NORTH);
		pg.add(north_2, BorderLayout.CENTER);
		pg.add(north_3,BorderLayout.SOUTH);

		add(pg, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);

		setBounds(200, 200, 550, 400);
		
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new Exam02();

	}

}
