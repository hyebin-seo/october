package mainUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CustomJsp extends JScrollPane{
	public CustomJsp(Component view, int vsbPolicy, int hsbPolicy) {
		this.setViewportView(view);
		this.setVerticalScrollBarPolicy(vsbPolicy);
		this.setHorizontalScrollBarPolicy(hsbPolicy);
		this.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		this.setForeground(Color.GRAY);
		this.setBorder(new LineBorder(Color.LIGHT_GRAY));
		this.setOpaque(false);
		this.getViewport().setBackground(Color.WHITE);
		this.setFont(new Font("맑은 고딕", Font.BOLD, 12));
	}
}
