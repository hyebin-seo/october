package mainUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class SettingPane extends JPanel implements ActionListener{

	// 이미지 경로
//	private String FILE_PATH = "../image/invisibleBtImg.png";
	
	// 넘겨받은 백, 메뉴 패널
	private JPanel backPane;
	private MenuPane menuPane;
	
	// 관리 메뉴 - 세부 패널을 담는 패널
	private JPanel settingDetailPane;
	
	// 관리 메뉴 - 세부 카테고리 패널
	private JPanel settingCategoryPane;
	
	// 관리 메뉴 - 세부 카테고리 버튼
	private JLabel settingTitle;
	private JButton myInfoBt;
	private JButton customBt;
	private JButton friendBt;

	// 관리 메뉴 - 세부 패널
	private JPanel myInfoPane;
	private JPanel customPane;
	private JPanel friendPane;
	
	// 관리 메뉴 - 세부 디테일 패널 컴포넌트
	// 내정보 컴포넌트
	private JLabel myInfoLb;
	private JLabel idLb;
	private JLabel pwdLb;
	private JLabel birthLb;
	private JButton modifyBt;

	// 메뉴 설정 컴포넌트
	private JLabel menuTitleLb;
	private JCheckBox menuPicture;
	private JCheckBox menuDiary;
	private JCheckBox menuVisitor;
	
	// 스킨 설정 컴포넌트
	private JLabel skinTItleLb;
	private JRadioButton skinListRb;

	// 음악 설정 컴포넌트
	private JLabel musicTitleLb;
	private JRadioButton musicRb;
	
	// 적용하기 컴포넌트
	private JButton customOkBt;

	// 일촌 설정 컴포넌트
	private JLabel existFriendLb;
	private JLabel deleteFriendLb;
	private JLabel friendLb;
	private JList friendJl;
	private JList friendDeleteJl;
	private JButton friendDelBt;
	private JButton friendOkBt;
	
	public SettingPane() { }
	
	public SettingPane(JPanel backPane, MenuPane menuPane) {
		
		this.backPane = backPane;
		this.menuPane = menuPane;
		
		this.setBounds(40, 40, 910, 600);
		this.setLayout(null);
		
		// 관리 메뉴 센터 패널
		settingDetailPane = new JPanel();

		// 관리 메뉴 - 카테고리 패널 선언
		myInfoPane = new JPanel();
		myInfoPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		customPane = new JPanel();
		friendPane = new JPanel();
		
		// 관리 메뉴 - 카테고리 목록, 디테일 패널
		settingCategoryPane = new JPanel();
		settingCategoryPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		settingCategoryPane.setBounds(0, 0, 260, 600);
		this.add(settingCategoryPane);
		settingDetailPane.setBounds(260, 0, 650, 600);
		this.add(settingDetailPane);
		settingCategoryPane.setBackground(Color.WHITE);
		settingCategoryPane.setLayout(null);
		
		// 관리 메뉴 - 세부 카테고리 버튼
		settingTitle = new JLabel("미니홈피 관리");
		settingTitle.setHorizontalAlignment(SwingConstants.CENTER);
		settingTitle.setBounds(30, 43, 150, 15);
		settingCategoryPane.add(settingTitle);
		
		myInfoBt = new JButton("기본 정보");
		myInfoBt.setBounds(40, 80, 130, 30);
		myInfoBt.setContentAreaFilled(false); //배경 표시
		myInfoBt.setFocusPainted(false);
		settingCategoryPane.add(myInfoBt);
		
		customBt = new JButton("개인 설정"); // 메뉴 셋팅, 스킨, 음악
		customBt.setBounds(40, 120, 130, 30);
		customBt.setContentAreaFilled(false); //배경 표시
		customBt.setFocusPainted(false);
		settingCategoryPane.add(customBt);
		
		friendBt = new JButton("일촌 관리");
		friendBt.setBounds(40, 160, 130, 30);
		friendBt.setContentAreaFilled(false); //배경 표시
		friendBt.setFocusPainted(false);
		settingCategoryPane.add(friendBt);
		
		friendBt.addActionListener(this);
		customBt.addActionListener(this);
		myInfoBt.addActionListener(this);
		
		// 관리 세부 패널 배경 설정
		settingDetailPane.setLayout(new CardLayout(0, 0));
		myInfoPane.setBackground(Color.WHITE);
		customPane.setBackground(Color.WHITE);
		friendPane.setBackground(Color.WHITE);
		
		// 관리 세부 패널에 카드 패널 추가
		settingDetailPane.add(myInfoPane, "myInfo"); 
		settingDetailPane.add(customPane, "setMenu");
		settingDetailPane.add(friendPane, "friend");

		// 관리 메뉴 - 내정보 패널
		myInfoLb = new JLabel("아이디");
		myInfoPane.setLayout(null);
		JLabel label = new JLabel("내정보");
		label.setBounds(146, 11, 100, 15);
		myInfoPane.add(label);
		myInfoLb.setFont(new Font("굴림", Font.PLAIN, 22));
		
		idLb = new JLabel("아이디");
		idLb.setBounds(60, 41, 66, 26);
		myInfoPane.add(idLb);
		idLb.setFont(new Font("굴림", Font.PLAIN, 22));
		
		pwdLb = new JLabel("비밀번호");
		pwdLb.setBounds(60, 82, 88, 26);
		myInfoPane.add(pwdLb);
		pwdLb.setFont(new Font("굴림", Font.PLAIN, 22));
		
		birthLb = new JLabel("가입한지 : 00일");
		birthLb.setBounds(60, 130, 152, 26);
		myInfoPane.add(birthLb);
		birthLb.setFont(new Font("굴림", Font.PLAIN, 22));
		
		modifyBt = new JButton("내정보 수정하기");
		modifyBt.setBounds(60, 160, 152, 26);
		modifyBt.setContentAreaFilled(false); //배경 표시
		modifyBt.setFocusPainted(false);
		myInfoPane.add(modifyBt);
		
		
		// 관리 메뉴 - 개인 설정 패널
		customPane.setLayout(null);
		menuPicture = new JCheckBox("사진첩");
		menuPicture.setSelected(true);
		menuPicture.setBounds(78, 114, 61, 23);
		customPane.add(menuPicture);
		menuDiary = new JCheckBox("다이어리");
		menuDiary.setSelected(true);
		menuDiary.setBounds(78, 152, 73, 23);
		customPane.add(menuDiary);
		menuVisitor = new JCheckBox("방명록");
		menuVisitor.setSelected(true);
		menuVisitor.setBounds(78, 194, 61, 23);
		customPane.add(menuVisitor);
		
		skinListRb = new JRadioButton("임시스킨1");
		skinListRb.setBounds(78, 333, 100, 15);
		customPane.add(skinListRb);
		
		musicRb = new JRadioButton("임시음악");
		musicRb.setBounds(78, 466, 73, 23);
		customPane.add(musicRb);
		
		customOkBt = new JButton("적용");
		customOkBt.setBounds(518, 536, 81, 23);
		customOkBt.setContentAreaFilled(false);
		customOkBt.setFocusPainted(false);
		customOkBt.addActionListener(this);
		customPane.add(customOkBt);
		
		menuTitleLb = new JLabel("메뉴 설정");
		menuTitleLb.setBounds(78, 69, 300, 15);
		customPane.add(menuTitleLb);
		
		skinTItleLb = new JLabel("스킨 설정");
		skinTItleLb.setBounds(78, 283, 57, 15);
		customPane.add(skinTItleLb);
		
		musicTitleLb = new JLabel("음악 설정");
		musicTitleLb.setBounds(78, 431, 57, 15);
		customPane.add(musicTitleLb);
		
		// 관리 메뉴 - 일촌 관리 패널
		friendPane.setLayout(null);
		friendLb = new JLabel("나의 일촌 목록");
		friendLb.setBounds(290, 20, 100, 15);
		friendPane.add(friendLb);
		friendLb.setBackground(Color.WHITE);
		
		friendJl = new JList(); // 현재 일촌 목록
		friendJl.setBorder(new LineBorder(new Color(0, 0, 0)));
		friendJl.setBounds(30, 70, 250, 300);
		friendPane.add(friendJl);
		
		friendDeleteJl = new JList(); // 삭제할 일촌 목록
		friendDeleteJl.setBorder(new LineBorder(Color.LIGHT_GRAY));
		friendDeleteJl.setBounds(380, 70, 250, 300);
		friendPane.add(friendDeleteJl);
		
		friendDelBt = new JButton(">>");
		friendDelBt.setContentAreaFilled(false);
		friendDelBt.setFocusPainted(false);
		friendDelBt.setBounds(300, 200, 60, 23);
		friendPane.add(friendDelBt);
		
		existFriendLb = new JLabel("일촌 목록");
		existFriendLb.setBounds(120, 45, 57, 15);
		friendPane.add(existFriendLb);
		
		deleteFriendLb = new JLabel("삭제할 일촌");
		deleteFriendLb.setHorizontalAlignment(SwingConstants.CENTER);
		deleteFriendLb.setBounds(460, 45, 80, 15);
		friendPane.add(deleteFriendLb);
		
		friendOkBt = new JButton("일촌 끊기");
		friendOkBt.setBounds(533, 507, 97, 23);
		friendOkBt.setContentAreaFilled(false);
		friendOkBt.setFocusPainted(false);
		friendPane.add(friendOkBt);
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout c1 = (CardLayout)settingDetailPane.getLayout();
		String btName = e.getActionCommand();
		
		switch (btName) {
			case "기본 정보":
				c1.show(settingDetailPane,"myInfo");
				break;
				
			case "개인 설정":
				c1.show(settingDetailPane,"setMenu");		
				break;
				
			case "일촌 관리":
				c1.show(settingDetailPane,"friend");
				break;
				
			case "적용": // 커스텀 설정
				if(menuPicture.isSelected()) {
					menuPane.gallaryBt.setVisible(true);
				} else {
					menuPane.gallaryBt.setVisible(false);
				}
				
				if(menuDiary.isSelected()) {
					menuPane.diaryBt.setVisible(true);
				} else {
					menuPane.diaryBt.setVisible(false);
				}
				
				if(menuVisitor.isSelected()) {
					menuPane.bookBt.setVisible(true);
				} else {
					menuPane.bookBt.setVisible(false);
				}
				
				menuPane.revalidate();
				menuPane.repaint();
				
				backPane.revalidate();
				backPane.repaint();

				break;	
				
	
			default:
				break;
		}

	}
}
