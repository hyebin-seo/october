package mainUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import java.awt.GridLayout;

public class MenuPane extends JPanel implements ActionListener{

	// 매개 변수 - 홈 카드 레이아웃
	private JPanel backPane;
	
	RoundedButton homeBt;
	RoundedButton diaryBt;
	RoundedButton gallaryBt;
	RoundedButton bookBt;
	RoundedButton settingBt;
	
//	public MenuPane() {	}
	
	public MenuPane(JPanel backPane) {
		
		this.backPane = backPane;

		this.setBounds(950, 50, 80, 252);
		this.setVisible(true);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setOpaque(false);
        this.setLayout(new GridLayout(0, 1, 0, 0));
		
        homeBt = new RoundedButton("Home");
        homeBt.setHorizontalAlignment(SwingConstants.LEFT);
        homeBt.addActionListener(this);
        this.add(homeBt);
        
        diaryBt = new RoundedButton("Diary");
        diaryBt.setHorizontalAlignment(SwingConstants.LEFT);
        diaryBt.addActionListener(this);
        this.add(diaryBt);
        
        gallaryBt = new RoundedButton("Gallery");
        gallaryBt.setHorizontalAlignment(SwingConstants.LEFT);
        gallaryBt.addActionListener(this);
        this.add(gallaryBt);
        
        bookBt = new RoundedButton("Visitor");
        bookBt.setHorizontalAlignment(SwingConstants.LEFT);
        bookBt.addActionListener(this);
        this.add(bookBt);
        
        settingBt = new RoundedButton("Setting");
        settingBt.setHorizontalAlignment(SwingConstants.LEFT);
        settingBt.addActionListener(this);
        this.add(settingBt);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout c1 = (CardLayout)backPane.getLayout();
		String btName = e.getActionCommand();
		
		switch (btName) {
			case "Home":
				c1.show(backPane,"home");
				break;
				
			case "Diary":
				c1.show(backPane,"diary");		
				break;
						
			case "Gallery":
				c1.show(backPane,"gallery");
				break;
				
			case "Visitor":
				c1.show(backPane,"book");
				break;
				
			case "Setting":
				c1.show(backPane,"setting");
				break;
	
			default:
				break;
		}

	}
}
