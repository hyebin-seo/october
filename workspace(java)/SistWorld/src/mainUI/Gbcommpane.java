package mainUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.GuestBookCommDTO;
import model.Member;

public class Gbcommpane extends JPanel{

	private Member member;
	JTextArea guestBookCommentContent;
	
	public Gbcommpane(Member gbcmember, GuestBookCommDTO gbcd) {
		
		this.setBackground(new Color(245, 245, 245));
		this.setBounds(12, 10, 587, 47);
		this.setLayout(null);
		this.member = gbcmember;
		
		RoundedButton guestBookCommentWriterBt = new RoundedButton(member.getMember_id());
		guestBookCommentWriterBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		guestBookCommentWriterBt.setBounds(12, 10, 89, 23);
		this.add(guestBookCommentWriterBt);

		guestBookCommentContent = new JTextArea(gbcd.getContent());
		guestBookCommentContent.setEditable(false);
		guestBookCommentContent.setBackground(new Color(245, 245, 245));
		guestBookCommentContent.setBounds(107, 0, 480, 47);
		this.add(guestBookCommentContent);
	}
	
}
