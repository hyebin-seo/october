package mainUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import db.DBConnection;
import model.Member;
import service.MasterSession;

public class LoginFrame extends JFrame{

	// 환영문구
	private JLabel welcomeLb;

	// 아이디
	private JLabel idLb;
	private JTextField idTf;
	
	// 비밀번호
	private JLabel pwdLb;
	private JPasswordField pwdPf;

	// 로그인버튼
	private RoundedButton loginBt;
	
	// 회원가입 버튼
	private RoundedButton joinBt;
	
	// 배경 패널
	private JPanel login;
	
	public LoginFrame() {

		getContentPane().setLayout(null);

		login = new JPanel();
		login.setBackground(Color.WHITE);
		login.setBounds(387, 95, 500, 500);
		login.setLayout(null);
		getContentPane().add(login);
		
		//환영 라벨
		welcomeLb = new JLabel("Welcome! SistWorld");
		welcomeLb.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		welcomeLb.setBounds(18, 100, 463, 80);
		welcomeLb.setForeground(new Color(9,131,178));
		welcomeLb.setHorizontalAlignment(SwingConstants.CENTER);
		
		//비밀번호 입력
		pwdLb = new JLabel("PASSWORD : ", SwingConstants.RIGHT);
		pwdLb.setForeground(new Color(9,131,178));
		pwdLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		pwdLb.setBounds(128, 229, 90, 30);

		//아이디 입력
		idLb = new JLabel("ID : ", SwingConstants.RIGHT);
		idLb.setForeground(new Color(9,131,178));
		idLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		idLb.setBounds(118, 189, 100, 30);
		
		//회원가입버튼
		joinBt = new RoundedButton("회원가입");
		joinBt.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		joinBt.setText("SIGN UP");
		joinBt.setBounds(140, 334, 220, 40);
		
		// 아이디 입력
		idTf = new JTextField(10);
		idTf.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		idTf.setBounds(230, 191, 130, 30);
		idTf.setText("hong"); //TODO 임시
		
		// 비밀번호 입력
		pwdPf = new JPasswordField(10);
		pwdPf.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pwdPf.setBounds(230, 231, 130, 30);
		pwdPf.setText("1111"); //TODO 임시
		
		//로그인버튼
		loginBt = new RoundedButton("로그인");
		loginBt.setText("LOGIN");
		loginBt.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		loginBt.setBounds(140, 284, 220, 40);
		
		login.add(welcomeLb);
		login.add(idLb);
		login.add(idTf);
		login.add(pwdLb);
		login.add(pwdPf);
		login.add(joinBt);
		login.add(loginBt);
		
		//프레임 설정 - 컴포넌트 생성 문제 있으니 제일 뒤로 뺄것
		this.setBounds(0, 0, 1280, 720);
		this.setResizable(false);
		this.setLocationRelativeTo(null);//창이 가운데 나오게
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("SistWorld");
		
		getContentPane().setBackground(Color.WHITE);
		
		//회원가입 이벤트
		joinBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 회원가입 프레임과 객체 생성할 것
				new JoinFrame();
				
			}
		});

		//엔터치면 로그인
		Action ok = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userId = idTf.getText();
				String userPwd = new String(pwdPf.getPassword());
				
				DBConnection dbc = DBConnection.getInstance();
				MasterSession ms = MasterSession.getInstance();
				boolean loginCheck = dbc.loginCheck(userId,userPwd);
				
				if(loginCheck) {
					// 아이디 비밀번호 체킹 후 일치하면 UserID 넘김.
//						JOptionPane.showMessageDialog(null, userId+"님! 환영합니다.");
					Member member = dbc.dataOpen(userId);
					ms.setMaster_id(userId);
					ms.setMaster_member(member);
					new HomeFrame(member.getMember_id());
					dispose();
					
				} else {
					// 아이디 비밀번호 체킹 후 일치하지 않으면
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 일치하지 않습니다.","로그인", JOptionPane.ERROR_MESSAGE);
				}
			}

		};
		
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
		pwdPf.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		pwdPf.getActionMap().put("ENTER", ok);

		// 로그인 이벤트
		loginBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String userId = idTf.getText();
				String userPwd = new String(pwdPf.getPassword());
				
				DBConnection dbc = DBConnection.getInstance();
				MasterSession ms = MasterSession.getInstance();
				boolean loginCheck = dbc.loginCheck(userId,userPwd);
				
				if(loginCheck) {
					// 아이디 비밀번호 체킹 후 일치하면 UserID 넘김.
//						JOptionPane.showMessageDialog(null, userId+"님! 환영합니다.");
					Member member = dbc.dataOpen(userId);
					ms.setMaster_id(userId);
					ms.setMaster_member(member);
					new HomeFrame(member.getMember_id());
					dispose();
					
				} else {
					// 아이디 비밀번호 체킹 후 일치하지 않으면
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 일치하지 않습니다.","로그인", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}
}

	
