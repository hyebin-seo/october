package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

public class Home {

	private JFrame mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setForeground(Color.ORANGE);
		mainFrame.setResizable(false);
		mainFrame.setBounds(100, 100, 900, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		JScrollPane category = new JScrollPane();
		category.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		category.setBounds(12, 40, 200, 500);
		category.getViewport().setBackground(Color.WHITE);
		mainFrame.getContentPane().add(category);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new EmptyBorder(10, 10, 10, 10));
		verticalBox.setBackground(Color.WHITE);
		category.setViewportView(verticalBox);
		
		JLabel lblNewLabel = new JLabel("미니홈피 관리");
		verticalBox.add(lblNewLabel);
		
		JButton myInfoBt = new JButton("기본정보");
		verticalBox.add(myInfoBt);
		
		JButton menuBt = new JButton("메뉴 설정");
		verticalBox.add(menuBt);
		
		JButton skinBt = new JButton("스킨 설정");
		verticalBox.add(skinBt);
		
		JButton musicBt = new JButton("음악 설정");
		verticalBox.add(musicBt);
		
		JButton firendBt = new JButton("일촌 관리");
		verticalBox.add(firendBt);
		
		JScrollPane setting = new JScrollPane();
		setting.setBounds(224, 40, 422, 500);
		mainFrame.getContentPane().add(setting);
		
		myInfoBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.getContentPane().add(infoSetting(setting));
				System.out.println(11);
			}
		});
		
		menuBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuSetting(setting);
				
			}
		});
		
		skinBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				skinSetting(setting);
				
			}
		});
		
		musicBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				musicSetting(setting);
				
			}
		});
		
		
	}

	// 기본 정보 패널 생성
	public JScrollPane infoSetting(JScrollPane setting) {
		
		setting.removeAll();

		JLabel myInfoLb = new JLabel("내정보");
		setting.add(myInfoLb);
		myInfoLb.setFont(new Font("굴림", Font.PLAIN, 22));
		
		JLabel idLb = new JLabel("아이디");
		setting.add(idLb);
		idLb.setFont(new Font("굴림", Font.PLAIN, 22));
		
		JLabel pwdLb = new JLabel("비밀번호");
		setting.add(pwdLb);
		pwdLb.setFont(new Font("굴림", Font.PLAIN, 22));
		
		JLabel birthLb = new JLabel("가입한지 : 00일");
		setting.add(birthLb);
		birthLb.setFont(new Font("굴림", Font.PLAIN, 22));
		
		return setting;
	}
	
	// 메뉴 설정 패널 생성
	public JScrollPane menuSetting(JScrollPane setting) {
		setting.removeAll();
	
		JCheckBox menuPicture = new JCheckBox("사진첩");
		setting.add(menuPicture);
		JCheckBox menuDiary = new JCheckBox("다이어리");
		setting.add(menuDiary);
		JCheckBox menuVisitor = new JCheckBox("방명록");
		setting.add(menuVisitor);
		
		return setting;
	}
	
	// 음악 설정 패널 생성
	public void musicSetting(JScrollPane setting) {
		setting.removeAll();

		JRadioButton musicRb = new JRadioButton("임시음악");
		setting.add(musicRb);
		
		JButton btnNewButton_5 = new JButton("음악설정");
		setting.add(btnNewButton_5);
	}
	
	// 스킨 설정 패널 생성
	public void skinSetting(JScrollPane setting) {
		setting.removeAll();

		JLabel pictureLb = new JLabel("사진");
		setting.add(pictureLb);
		pictureLb.setBackground(Color.WHITE);
		
		JButton pictureBt = new JButton("선택");
		setting.add(pictureBt);
	}
}
