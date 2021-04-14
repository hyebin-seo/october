package mainUI;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Member;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import service.MasterSession;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Dimension;

public class MenuPane extends JPanel implements ActionListener{

	// 매개 변수 - 홈 카드 레이아웃
	private JPanel backPane;
	RoundedButton diaryBt;
	RoundedButton gallaryBt;
	RoundedButton bookBt;
	RoundedButton settingBt;
	
//	public MenuPane() {	}
	
	public MenuPane(Member member, JPanel backPane) {
		MasterSession ms = MasterSession.getInstance();
		this.backPane = backPane;

		this.setBounds(970, 50, 80, 250);
		this.setVisible(true);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setOpaque(false);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
        RoundedButton homeBt = new RoundedButton("Home");
        homeBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        homeBt.setHorizontalAlignment(SwingConstants.LEFT);
        homeBt.setPreferredSize(new Dimension(80, 50));
        homeBt.addActionListener(this);
        this.add(homeBt);
        
        diaryBt = new RoundedButton("Diary");
        diaryBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        diaryBt.setHorizontalAlignment(SwingConstants.LEFT);
        diaryBt.addActionListener(this);
        diaryBt.setPreferredSize(new Dimension(80, 50));
        this.add(diaryBt);
        if(!member.isHome_diary()) { //설정값에 따라 메뉴 버튼 표시
        	diaryBt.setVisible(false);
        }
        
        
        gallaryBt = new RoundedButton("Gallery");
        gallaryBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        gallaryBt.setHorizontalAlignment(SwingConstants.LEFT);
        gallaryBt.addActionListener(this);
        gallaryBt.setPreferredSize(new Dimension(80, 50));
        this.add(gallaryBt);
        if(!member.isHome_gallery()) { //설정값에 따라 메뉴 버튼 표시
        	gallaryBt.setVisible(false);
        }
        
        bookBt = new RoundedButton("Visitor");
        bookBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        bookBt.setHorizontalAlignment(SwingConstants.LEFT);
        bookBt.addActionListener(this);
        bookBt.setPreferredSize(new Dimension(80, 50));
        this.add(bookBt);
        if(!member.isHome_book()) { //설정값에 따라 메뉴 버튼 표시
        	bookBt.setVisible(false);
        }
        
        if(ms.getMaster_id().equals(member.getMember_id())) {
	        settingBt = new RoundedButton("Setting");
	        settingBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
	        settingBt.setHorizontalAlignment(SwingConstants.LEFT);
	        settingBt.setPreferredSize(new Dimension(80, 50));
	        settingBt.addActionListener(this);
	        this.add(settingBt);
        }
	}
	
	public void menuSetting(Member member) {
		if(member.isHome_diary()) { //설정값에 따라 메뉴 버튼 표시
        	diaryBt.setVisible(true);
        } else {
        	diaryBt.setVisible(false);
        }
		if(member.isHome_gallery()) { //설정값에 따라 메뉴 버튼 표시
        	gallaryBt.setVisible(true);
        } else {
        	gallaryBt.setVisible(false);
        }
		if(member.isHome_book()) { //설정값에 따라 메뉴 버튼 표시
        	bookBt.setVisible(true);
        } else {
        	bookBt.setVisible(false);
        }
		
		this.revalidate();
		this.repaint();
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
