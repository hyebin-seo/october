package sist;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Ex31_Event extends Frame implements MouseListener{
	
	CardLayout card = new CardLayout();
	
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	JPanel jp4 = new JPanel();
	
	public Ex31_Event() {
		setTitle("CardLayout 예제");
		
		setLayout(card);
		
		jp1.setBackground(Color.BLUE);
		jp2.setBackground(Color.YELLOW);
		jp3.setBackground(Color.CYAN);
		jp4.setBackground(Color.GRAY);
		
		jp1.add(new JLabel("Card1"));
		jp2.add(new JLabel("Card2"));
		jp3.add(new JLabel("Card3"));
		jp4.add(new JLabel("Card4"));
		
		add(jp1, "1"); add(jp2, "2");
		add(jp3, "3"); add(jp4, "4");
		
		jp1.addMouseListener(this);
		jp2.addMouseListener(this);	
		jp3.addMouseListener(this);	
		jp4.addMouseListener(this);	
		
		setBounds(200, 200, 300, 300);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new Ex31_Event();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		card.next(this);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
