package mainUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import dao.DBConnection;
import model.Member;
import javax.swing.JButton;

public class ProfilePane extends JPanel{

	// 매개변수
	private Member member;
	
	// 홈 메뉴 - 세부 프로필 컴포넌트
	private JLabel profilePicLb;
	private JTextArea profileMsgTa;
	private JScrollPane profilestatusJs;
	private JLabel profileInfoLb;
	private JButton profileModifyBt;
	private JButton profileModifyCBt;
	private JButton profilePicModifyBt;
	
	public ProfilePane(Member memberc) {
		// 홈 메뉴 - 세부 프로필 패널
		this.setBorder(new LineBorder(new Color(192, 192, 192)));
		this.setBounds(0, 0, 260, 600);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.member = memberc;

		//프로필 메시지 수정 들어가기
		profileModifyBt = new JButton("");
		profileModifyBt.setText("Modify");
		profileModifyBt.setBorder(new LineBorder(Color.LIGHT_GRAY));
		profileModifyBt.setBackground(Color.WHITE);
		profileModifyBt.setOpaque(false);
		profileModifyBt.setContentAreaFilled(false);
		profileModifyBt.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		profileModifyBt.setBounds(20, 440, 220, 20);
		add(profileModifyBt);
		
		profileModifyBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				profileMsgTa.setEnabled(true);
				profileMsgTa.setEditable(true);
				profileModifyBt.setVisible(false);
				profileModifyCBt.setVisible(true);

			}
		});
		add(profileModifyCBt);
		
		//프로필 메시지 수정 완료 버튼
		profileModifyCBt = new JButton("");
		profileModifyCBt.setText("Complete!");
		profileModifyCBt.setBorder(new LineBorder(Color.LIGHT_GRAY));
		profileModifyCBt.setBackground(Color.WHITE);
		profileModifyCBt.setOpaque(false);
		profileModifyCBt.setContentAreaFilled(false);
		profileModifyCBt.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		profileModifyCBt.setBounds(20, 440, 220, 20);
		profileModifyCBt.setVisible(false);
		profileModifyCBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				member.setHome_profile_msg(profileMsgTa.getText());
				DBConnection dbc = DBConnection.getInstance();
				member = dbc.modifyMyProfileMsg(member);
				profileMsgTa.setText(member.getHome_profile_msg());
				profileMsgTa.setEnabled(false);
				profileMsgTa.setEditable(false);
				profileModifyBt.setVisible(true);
				profileModifyCBt.setVisible(false);
				
			}
		});

		// 홈 메뉴 - 프로필 사진
		profilePicLb = new JLabel("");
		profilePicLb.setIcon
		(new ImageIcon(HomePane.class.getResource(member.getHome_profile_pic())));
		profilePicLb.setHorizontalAlignment(SwingConstants.CENTER);
		profilePicLb.setBounds(20, 55, 220, 170);
		this.add(profilePicLb);
		
		// 홈 메뉴 - 프로필 상태 메시지(원본)
		profileMsgTa = new JTextArea(5,19);
		profileMsgTa.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		profileMsgTa.setForeground(Color.BLACK);
		profileMsgTa.setEnabled(false);
		profileMsgTa.setEditable(false);
		profileMsgTa.setText(member.getHome_profile_msg());
		JScrollPane profileMsgJs = new JScrollPane(
				profileMsgTa,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		profileMsgJs.setSize(220, 170);
		profileMsgJs.setLocation(20, 270);
		profileMsgJs.setForeground(Color.BLACK);
		this.add(profileMsgJs);
		
		// 홈 메뉴 - 프로필 정보
		profileInfoLb = new JLabel(member.getMember_name()+" | "+
								   member.getMember_gender()+" | "+
								   member.getMember_birth());
		profileInfoLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		profileInfoLb.setHorizontalAlignment(SwingConstants.CENTER);
		profileInfoLb.setBounds(20, 470, 220, 50);
		this.add(profileInfoLb);
		
		profilePicModifyBt = new JButton("Modify");
		profilePicModifyBt.setOpaque(false);
		profilePicModifyBt.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		profilePicModifyBt.setContentAreaFilled(false);
		profilePicModifyBt.setBorder(new LineBorder(Color.LIGHT_GRAY));
		profilePicModifyBt.setBackground(Color.WHITE);
		profilePicModifyBt.setBounds(20, 225, 220, 20);
		add(profilePicModifyBt);
	}
}
