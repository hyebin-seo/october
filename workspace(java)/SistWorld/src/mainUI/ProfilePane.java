package mainUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import db.DBConnection;
import model.FriendAsk;
import model.Member;
import service.FriendCheck;
import service.ImageResizeUpload;
import service.MasterSession;

import javax.swing.border.EmptyBorder;

public class ProfilePane extends JPanel{
	DBConnection dbc = DBConnection.getInstance();
	MasterSession ms = MasterSession.getInstance();

	// 매개변수
	private Member member;
	
	// 홈 메뉴 - 세부 프로필 컴포넌트
	private JLabel profilePicLb;
	private JTextArea profileMsgTa;
	private JScrollPane profileMsgJs;
	private JLabel profileInfoLb;
	private JButton profileModifyBt;
	private JButton profileModifyCBt;
	private JButton profilePicModifyBt;
	private RoundedButton friendAskBt;
	private RoundedButton surferBt;
	
	public void subSetting() {
		profileModifyBt.setVisible(false);
		profilePicModifyBt.setVisible(false);
		//일촌 여부
		int friend = new FriendCheck(member.getMember_id(), ms.getMaster_id()).FriendCheckR();
		if(friend > 0) {
			
		} else {
			friendAskBt.setVisible(true);
		}
	}
	
	public ProfilePane(String master_id, Member memberc) {
		
		// 홈 메뉴 - 세부 프로필 패널
		this.setBorder(new LineBorder(new Color(192, 192, 192)));
		this.setBounds(0, 0, 260, 600);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.member = memberc;
		
		profileModifyBt = new JButton("");
		profileModifyCBt = new JButton("");
		profilePicLb = new JLabel("");
		profileMsgTa = new JTextArea(5,19);
		profileInfoLb = new JLabel(member.getMember_name()+" | "+
				   				   member.getMember_gender()+" | "+
				   				   member.getMember_birth());
		profilePicModifyBt = new JButton("Edit");

		//프로필 메시지 수정 들어가기
		profileModifyBt.setText("Edit");
		profileModifyBt.setBorder(null);
		profileModifyBt.setBackground(Color.WHITE);
		profileModifyBt.setForeground(Color.GRAY);
		profileModifyBt.setOpaque(false);
		profileModifyBt.setContentAreaFilled(false);
		profileModifyBt.setFocusPainted(false);
		profileModifyBt.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		profileModifyBt.setBounds(20, 440, 42, 20);
		add(profileModifyBt);
		
		profileModifyBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				profileMsgTa.setEnabled(true);
				profileMsgTa.setEditable(true);
				profileMsgTa.requestFocus();
				profileModifyBt.setVisible(false);
				profileModifyCBt.setVisible(true);

			}
		});
		add(profileModifyCBt);
		
		//프로필 메시지 수정 완료 버튼
		profileModifyCBt.setText("OK");
		profileModifyCBt.setBorder(null);
		profileModifyCBt.setBackground(Color.WHITE);
		profileModifyCBt.setForeground(Color.GRAY);
		profileModifyCBt.setOpaque(false);
		profileModifyCBt.setContentAreaFilled(false);
		profileModifyCBt.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		profileModifyCBt.setBounds(198, 440, 42, 20);
		profileModifyCBt.setVisible(false);
		profileModifyCBt.setFocusPainted(false);
		profileModifyCBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				member.setHome_profile_msg(profileMsgTa.getText());
				DBConnection dbc = DBConnection.getInstance();
				member = dbc.modifyMySetting("msg",member);
				profileMsgTa.setText(member.getHome_profile_msg());
				profileMsgTa.setEditable(false);
				profileModifyBt.setVisible(true);
				profileModifyCBt.setVisible(false);
				
			}
		});
		
		// 프로필 사진 수정 버튼
		profilePicModifyBt.setOpaque(false);
		profilePicModifyBt.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		profilePicModifyBt.setContentAreaFilled(false);
		profilePicModifyBt.setBorder(null);
		profilePicModifyBt.setBackground(Color.WHITE);
		profilePicModifyBt.setBounds(20, 227, 42, 20);
		profilePicModifyBt.setForeground(Color.GRAY);
		profilePicModifyBt.setFocusPainted(false);
		add(profilePicModifyBt);

		// 홈 메뉴 - 프로필 사진
		Image Img = new ImageIcon(member.getHome_profile_pic()).getImage();
		Image ImgResize = Img.getScaledInstance(220, 170, java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizeIcon = new ImageIcon(ImgResize);
		profilePicLb.setIcon(resizeIcon);
		profilePicLb.setHorizontalAlignment(SwingConstants.CENTER);
		profilePicLb.setBounds(20, 55, 220, 170);
		this.add(profilePicLb);
		
		// 홈 메뉴 - 프로필 상태 메시지(원본)
		profileMsgTa.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		profileMsgTa.setForeground(Color.DARK_GRAY);
		profileMsgTa.setEditable(false);
		profileMsgTa.setText(member.getHome_profile_msg());
		profileMsgTa.setLineWrap(true);
		profileMsgJs = new JScrollPane(
				profileMsgTa,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		profileMsgJs.setSize(220, 170);
		profileMsgJs.setLocation(20, 270);
		profileMsgJs.setForeground(Color.BLACK);
		this.add(profileMsgJs);
		
		// 홈 메뉴 - 프로필 정보
		profileInfoLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		profileInfoLb.setForeground(new Color(9, 131, 178));
		profileInfoLb.setHorizontalAlignment(SwingConstants.CENTER);
		profileInfoLb.setBounds(20, 470, 220, 30);
		this.add(profileInfoLb);

		profilePicModifyBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					ImageResizeUpload iru = 
							new ImageResizeUpload("img", member.getMember_id(), 220, 170);

					if(!iru.getUserImgPath().equals("NotExistFile")) {
						profilePicLb.setIcon(iru.getResizeIcon());
						
						//이전 프로필 사진 삭제(기본사진이면 삭제 안함)
						File file = new File(member.getHome_profile_pic());
						if(!file.getName().equals("profile.JPG")) {
							file.delete();
						}
						member.setHome_profile_pic(iru.getUserImgPath());
						member = dbc.modifyMySetting("pic",member);
					}

			}
		});
		
		//일촌신청 버튼 - sub일때만 출력
		FriendAsk ask = new FriendAsk();
		ask.setMember_id(member.getMember_id());
		ask.setFriend_id(ms.getMaster_member().getMember_id());
		
		friendAskBt = new RoundedButton("일촌 신청");
		friendAskBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		friendAskBt.setBounds(40, 541, 180, 30);
		friendAskBt.setVisible(false);
		this.add(friendAskBt);
		
		friendAskBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int rs = dbc.friendAsk("조회",ask);
				
				if(rs > 0) {
					JOptionPane.showMessageDialog(null,
							"이미 신청하셨어요!\n상대방의 수락을 기다리세요!X_X","꽥!", JOptionPane.ERROR_MESSAGE);
				} else {
					new FriendAskFrame(member);
				}
			}
		});
		
		//파도타기 버튼
		surferBt = new RoundedButton("~낯선 사람 파도타기~");
		surferBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		surferBt.setBounds(40, 505, 180, 30);
		this.add(surferBt);

		//파도타기 액션
		surferBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String member_id = dbc.surfer();
				
				//현재 파도탄 홈페이지와 다른 이름만 가져오기
				while(member_id.equals(member.getMember_id())) {
					member_id = dbc.surfer();
				}
				
				while(member_id.equals(ms.getMaster_id())) {
					member_id = dbc.surfer();
				}
				
				new HomeFrame(member_id);
			}
		});
		
		if(!master_id.equals(member.getMember_id())) {
			subSetting();
		}
	}
}
