package mainUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import db.DBConnection;
import model.FriendAsk;
import model.Member;
import service.MasterSession;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class FriendAskFrame extends JFrame{
	private JTextField FriendNickTf;
	private JTextField myNickTf;
	int checkFlag = 0;
	
	DBConnection dbc = DBConnection.getInstance();

	public FriendAskFrame(Member member) {
		
		MasterSession ms = MasterSession.getInstance();
		
		getContentPane().setBackground(Color.WHITE);
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(0, 0, 300, 230);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel titleLb = new JLabel("일촌 신청 하기");
		titleLb.setBorder(null);
		titleLb.setForeground(new Color(9,131,178));
		titleLb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		titleLb.setHorizontalAlignment(SwingConstants.CENTER);
		titleLb.setBounds(72, 10, 150, 52);
		getContentPane().add(titleLb);
		
		// 아이디
		JLabel FriendNickLb = new JLabel(member.getMember_name()+"의 일촌명 :");
		FriendNickLb.setForeground(new Color(9,131,178));
		FriendNickLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		FriendNickLb.setBounds(12, 64, 110, 20);
		FriendNickLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(FriendNickLb);
		
		FriendNickTf = new JTextField();
		FriendNickTf.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		FriendNickTf.setBounds(134, 66, 130, 20);
		getContentPane().add(FriendNickTf);
		FriendNickTf.setColumns(10);
		
		// 비밀번호
		JLabel myNickLb = new JLabel(ms.getMaster_member().getMember_name()+"의 일촌명 :");
		myNickLb.setForeground(new Color(9,131,178));
		myNickLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		myNickLb.setBounds(12, 94, 110, 20);
		myNickLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(myNickLb);
		
		myNickTf = new JTextField();
		myNickTf.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		myNickTf.setBounds(134, 96, 130, 20);
		myNickTf.setColumns(10);
		getContentPane().add(myNickTf);
		
		// 가입버튼
		RoundedButton friendAskBt = new RoundedButton("가입하기");
		friendAskBt.setText("일촌이 되고 싶어요!");
		friendAskBt.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		friendAskBt.setOpaque(false);
		friendAskBt.setBounds(72, 135, 150, 30);
		getContentPane().add(friendAskBt);

		// 일촌신청
		friendAskBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FriendAsk ask = new FriendAsk();
				
				//미니홈페이지의 주인
				ask.setMember_id(member.getMember_id());
				ask.setMember_name(member.getMember_name());
				ask.setMember_nick(FriendNickTf.getText());
				
				//현재 접속한 사람
				ask.setFriend_id(ms.getMaster_member().getMember_id());
				ask.setFriend_name(ms.getMaster_member().getMember_name());
				ask.setFriend_nick(myNickTf.getText());
	
				if(FriendNickTf.getText().equals("")||myNickTf.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"일촌명을 모두 입력해야합니다!!!","신청 실패", JOptionPane.ERROR_MESSAGE);
				} else {
					int rs = dbc.friendAsk("신청", ask);
						
					if(rs > 0) {
						JOptionPane.showMessageDialog(null,"일촌 신청 완료.\n상대방이 수락할 때까지 기다리십시오.");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null,
								"오류로 인한 신청 실패! 다시 신청해주세요.","일촌 신청", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}
		});

	
	}
}
