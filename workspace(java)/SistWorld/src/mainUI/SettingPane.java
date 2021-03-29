package mainUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class SettingPane extends JPanel implements ActionListener{

	// 관리 메뉴 - 세부 패널을 담는 패널
	private JPanel settingDetailPane;
	
	// 관리 메뉴 - 세부 카테고리 패널
	private JPanel settingCategoryPane;
	
	// 관리 메뉴 - 세부 카테고리 박스
	private Box categoryVb;
	
	// 관리 메뉴 - 세부 카테고리 버튼
	private JLabel settingTitle;
	private JButton myInfoBt;
	private JButton menuBt;
	private JButton skinBt;
	private JButton musicBt;
	private JButton friendBt;

	// 관리 메뉴 - 세부 패널
	private JPanel myInfoPane;
	private JPanel setMenuPane;
	private JPanel skinPane;
	private JPanel musicPane;
	private JPanel friendPane;
	
	// 관리 메뉴 - 세부 디테일 패널 컴포넌트
	JLabel myInfoLb;
	JLabel idLb;
	JLabel pwdLb;
	JLabel birthLb;

	JCheckBox menuPicture;
	JCheckBox menuDiary;
	JCheckBox menuVisitor;

	JRadioButton musicRb;
	JButton musicOkBt;

	JLabel pictureLb;
	JButton pictureBt;
	JLabel friendLb;
	
	public SettingPane() {
		
		this.setBounds(40, 40, 910, 600);
		this.setLayout(null);
		
		// 관리 메뉴 센터 패널
		settingDetailPane = new JPanel();

		// 관리 메뉴 - 카테고리 패널 선언
		myInfoPane = new JPanel();
		setMenuPane = new JPanel();
		skinPane = new JPanel();
		musicPane = new JPanel();
		friendPane = new JPanel();
		
		// 관리 메뉴 - 카테고리 목록, 디테일 패널
		settingCategoryPane = new JPanel();
		settingCategoryPane.setBounds(0, 0, 260, 600);
		this.add(settingCategoryPane);
		settingDetailPane.setBounds(260, 0, 650, 600);
		this.add(settingDetailPane);
		settingCategoryPane.setBackground(Color.WHITE);
		settingCategoryPane.setLayout(null);
		
		// 관리 메뉴 - 세부 카테고리 박스
		categoryVb = Box.createVerticalBox();
		categoryVb.setBounds(12, 10, 176, 480);
		settingCategoryPane.add(categoryVb);
		categoryVb.setBorder(new EmptyBorder(10, 10, 10, 10));
		categoryVb.setBackground(Color.WHITE);
		
		// 관리 메뉴 - 세부 카테고리 버튼
		settingTitle = new JLabel("미니홈피 관리");
		categoryVb.add(settingTitle);
		
		myInfoBt = new JButton("기본 정보");
		categoryVb.add(myInfoBt);
		
		menuBt = new JButton("메뉴 설정");
		categoryVb.add(menuBt);
		
		skinBt = new JButton("스킨 설정");
		categoryVb.add(skinBt);
		
		musicBt = new JButton("음악 설정");
		categoryVb.add(musicBt);
		
		friendBt = new JButton("일촌 관리");
		categoryVb.add(friendBt);
		
		myInfoBt.addActionListener(this);
		menuBt.addActionListener(this);
		skinBt.addActionListener(this);
		musicBt.addActionListener(this);
		friendBt.addActionListener(this);
		
		// 관리 세부 패널 배경 설정
		settingDetailPane.setLayout(new CardLayout(0, 0));
		myInfoPane.setBackground(Color.WHITE);
		setMenuPane.setBackground(Color.WHITE);
		skinPane.setBackground(Color.WHITE);
		musicPane.setBackground(Color.WHITE);
		friendPane.setBackground(Color.WHITE);
		
		// 관리 세부 패널에 카드 패널 추가
		settingDetailPane.add(myInfoPane, "myInfo"); 
		settingDetailPane.add(setMenuPane, "setMenu");
		settingDetailPane.add(skinPane, "skin"); 
		settingDetailPane.add(musicPane, "music");
		settingDetailPane.add(friendPane, "friend");

		// 관리 메뉴 - 내정보 패널
		myInfoLb = new JLabel("아이디");
		myInfoPane.add(new JLabel("내정보"));
		myInfoLb.setFont(new Font("굴림", Font.PLAIN, 22));
		
		idLb = new JLabel("아이디");
		myInfoPane.add(idLb);
		idLb.setFont(new Font("굴림", Font.PLAIN, 22));
		
		pwdLb = new JLabel("비밀번호");
		myInfoPane.add(pwdLb);
		pwdLb.setFont(new Font("굴림", Font.PLAIN, 22));
		
		birthLb = new JLabel("가입한지 : 00일");
		myInfoPane.add(birthLb);
		birthLb.setFont(new Font("굴림", Font.PLAIN, 22));
		
		// 관리 메뉴 - 메뉴 설정 패널
		menuPicture = new JCheckBox("사진첩");
		setMenuPane.add(menuPicture);
		menuDiary = new JCheckBox("다이어리");
		setMenuPane.add(menuDiary);
		menuVisitor = new JCheckBox("방명록");
		setMenuPane.add(menuVisitor);
		
		// 관리 메뉴 - 음악 설정 패널
		musicRb = new JRadioButton("임시음악");
		musicPane.add(musicRb);
		
		musicOkBt = new JButton("음악설정");
		musicPane.add(musicOkBt);
		
		// 관리 메뉴 - 스킨 설정 패널
		pictureLb = new JLabel("사진");
		skinPane.add(pictureLb);
		pictureLb.setBackground(Color.WHITE);
		
		pictureBt = new JButton("선택");
		skinPane.add(pictureBt);
		
		// 관리 메뉴 - 일촌 관리 패널
		friendLb = new JLabel("일촌");
		friendPane.add(friendLb);
		friendLb.setBackground(Color.WHITE);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout c1 = (CardLayout)settingDetailPane.getLayout();
		String btName = e.getActionCommand();
		
		switch (btName) {
			case "기본 정보":
				c1.show(settingDetailPane,"myInfo");
				break;
				
			case "메뉴 설정":
				c1.show(settingDetailPane,"setMenu");		
				break;
						
			case "스킨 설정":
				c1.show(settingDetailPane,"skin");
				break;
				
			case "음악 설정":
				c1.show(settingDetailPane,"music");
				break;
				
			case "일촌 관리":
				c1.show(settingDetailPane,"friend");
				break;
	
			default:
				break;
		}

	}

}
