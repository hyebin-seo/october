package mainUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.DBConnection;
import dao.MemberDAO;
import model.Member;
public class HomePane extends JPanel{
	
	// 멤버정보
	Member member;

	// 홈 메뉴 - 세부 메인 패널
	private JPanel mainDetailPane;
	
	// 홈 메뉴 - 세부 프로필 패널
	private JPanel mainProfilePane;

	// 홈 메뉴 - 세부 프로필 컴포넌트
	private JLabel profilePicLb;
	private JTextArea profileStatusTa;
	private JLabel profileInfoLb;
	
	// 홈 메뉴 - 세부 메인 컴포넌트
	private JLabel homeImgLb;
	private JLabel friendLb;
	private JTextField frienTf;
//	private JTable freinTb;
	private RoundedButton freindBt;

	public HomePane(String memeber_id) {
		System.out.println("[HomePane]:"+memeber_id);
		MemberDAO md = MemberDAO.getInstance();
		member = md.get(memeber_id);
		
		// 세부 메인, 세부 프로필을 담는 패널
		this.setBounds(40, 40, 910, 600);
		this.setLayout(null);

		// 홈 메뉴 - 세부 메인 패널
		mainDetailPane = new JPanel();
		mainDetailPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		mainDetailPane.setBounds(260, 0, 650, 600);
		mainDetailPane.setBackground(Color.WHITE);
		mainDetailPane.setLayout(null);

		// 홈 메뉴 - 세부 프로필 패널
		mainProfilePane = new JPanel();
		mainProfilePane.setBorder(new LineBorder(new Color(192, 192, 192)));
		mainProfilePane.setBounds(0, 0, 260, 600);
		mainProfilePane.setBackground(Color.WHITE);
		mainProfilePane.setLayout(null);

		// 홈 메뉴 - 프로필 사진
		profilePicLb = new JLabel("");
		profilePicLb.setIcon
		(new ImageIcon(HomePane.class.getResource(member.getHome_profile_pic())));
		profilePicLb.setHorizontalAlignment(SwingConstants.CENTER);
		profilePicLb.setBounds(20, 70, 220, 170);
		mainProfilePane.add(profilePicLb);
		
		// 홈 메뉴 - 프로필 상태 메시지
		profileStatusTa = new JTextArea(5,30);
		profileStatusTa.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		profileStatusTa.setForeground(Color.BLACK);
		profileStatusTa.setEnabled(false);
		profileStatusTa.setEditable(false);
		profileStatusTa.setText(member.getHome_profile_msg());
		JScrollPane profilestatusJs = new JScrollPane(
				profileStatusTa,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		profilestatusJs.setSize(220, 170);
		profilestatusJs.setLocation(20, 270);
		profilestatusJs.setForeground(Color.BLACK);
		mainProfilePane.add(profilestatusJs);
		
		// 홈 메뉴 - 프로필 정보
		profileInfoLb = new JLabel(member.getMember_name()+" | "+
								   member.getMember_gender()+" | "+
								   member.getMember_birth());
		profileInfoLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		profileInfoLb.setHorizontalAlignment(SwingConstants.CENTER);
		profileInfoLb.setBounds(20, 470, 220, 50);
		mainProfilePane.add(profileInfoLb);
		
		// 홈 메뉴 - 미니룸 사진(라벨에 맞게 사이즈 재설정)
		homeImgLb = new JLabel();
		Image homeImg = new ImageIcon
				(HomePane.class.getResource(member.getHome_miniroom())).getImage();
		Image homeImgResize = homeImg.getScaledInstance(530, 310, java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizeIcon = new ImageIcon(homeImgResize);
		homeImgLb.setIcon(resizeIcon);
		homeImgLb.setBounds(60, 40, 530, 310);
		mainDetailPane.add(homeImgLb);

		this.add(mainDetailPane, "mainDetail");
		
		friendLb = new JLabel("일촌평");
		friendLb.setHorizontalAlignment(SwingConstants.LEFT);
		friendLb.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		friendLb.setBounds(58, 370, 40, 20);
		mainDetailPane.add(friendLb);
		
		frienTf = new JTextField();
		frienTf.setBounds(99, 370, 430, 20);
		mainDetailPane.add(frienTf);
		frienTf.setColumns(10);
		
		freindBt = new RoundedButton("확인");
		freindBt.setOpaque(false);
		freindBt.setHorizontalAlignment(SwingConstants.LEFT);
		freindBt.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		freindBt.setBounds(533, 370, 55, 20);
		mainDetailPane.add(freindBt);

		// 일촌평
		DBConnection dbc = DBConnection.getInstance();
		DefaultTableModel model = dbc.friendCmt(member.getMember_id());
		// 일촌평 헤더 "index","cmt","nick","name"
		JTable cmtTb = new JTable(model);
		cmtTb.setEnabled(false);
		cmtTb.getColumnModel().getColumn(0).setPreferredWidth(40);  //컬럼 길이 조절
		cmtTb.getColumnModel().getColumn(1).setPreferredWidth(150);
		cmtTb.getColumnModel().getColumn(2).setPreferredWidth(80);
		cmtTb.getColumnModel().getColumn(3).setPreferredWidth(60);

		
		JScrollPane jsp = new JScrollPane
				(cmtTb,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		jsp.setSize(530, 170);
		jsp.setLocation(60, 400);
		mainDetailPane.add(jsp);
		
		
		this.add(mainProfilePane, "mainProfile");
		this.setBackground(Color.BLACK);

	}
}
