package mainUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.DBConnection;
import dao.MemberDAO;
import model.Member;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

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
	
	// 회원 정보 목록
	private MemberDAO memberMap;
	
	// 배경 패널
	private JPanel LoginPanel;

	
	public LoginFrame() {
		
		//멤버 리스트 생성(싱글톤)
		memberMap = MemberDAO.getInstance();
		
		//프레임 설정
		this.setBounds(0, 0, 1280, 720);
		this.setResizable(false);
		this.setLocationRelativeTo(null);//창이 가운데 나오게
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("SistWorld");
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		//회원가입버튼
		joinBt = new RoundedButton("회원가입");
		joinBt.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		joinBt.setText("JOIN");
		joinBt.setBounds(527, 409, 220, 40);
		getContentPane().add(joinBt);
		
		//회원가입 이벤트
		joinBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 회원가입 프레임과 객체 생성할 것
				new JoinFrame();
				
			}
		});
		
		//로그인버튼
		loginBt = new RoundedButton("로그인");
		loginBt.setText("LOGIN");
		loginBt.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		loginBt.setBounds(527, 358, 220, 40);
		getContentPane().add(loginBt);
		
		// 로그인 이벤트
		loginBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String userId = idTf.getText();
				String userPwd = new String(pwdPf.getPassword());
				
				DBConnection dbc = DBConnection.getInstance();
				boolean loginCheck = dbc.loginCheck(userId,userPwd);
				
				if(loginCheck) {
					// 아이디 비밀번호 체킹 후 일치하면 UserID 넘김.
					// 객체 넘기지 않는 이유:일촌 파도타기 시 유저 식별 필요함.
//						JOptionPane.showMessageDialog(null, userId+"님! 환영합니다.");
					Member member = dbc.dataOpen(userId);
					memberMap.put(member.getMember_id(),member);
					new HomeFrame(member.getMember_id());
					dispose();
					
				} else {
					// 아이디 비밀번호 체킹 후 일치하지 않으면
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 일치하지 않습니다.","로그인", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//환영 라벨
		welcomeLb = new JLabel("Welcome! \r\nSistWorld");
		welcomeLb.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		welcomeLb.setBounds(-363, 160, 2000, 80);
		welcomeLb.setForeground(new Color(9,131,178));
		welcomeLb.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(welcomeLb);
		
		
		//아이디 입력
		idLb = new JLabel("ID : ", SwingConstants.RIGHT);
		idLb.setForeground(new Color(9,131,178));
		idLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		idLb.setBounds(507, 268, 100, 30);
		getContentPane().add(idLb);
		
		//비밀번호 입력
		pwdLb = new JLabel("PASSWORD : ", SwingConstants.RIGHT);
		pwdLb.setForeground(new Color(9,131,178));
		pwdLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		pwdLb.setBounds(517, 308, 90, 30);
		getContentPane().add(pwdLb);
		idTf = new JTextField(10);
		idTf.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		idTf.setBounds(619, 269, 130, 30);
		getContentPane().add(idTf);
		idTf.setText("admin"); //TODO 임시
		pwdPf = new JPasswordField(10);
		pwdPf.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pwdPf.setBounds(619, 309, 130, 30);
		getContentPane().add(pwdPf);
		pwdPf.setText("admin"); //TODO 임시

	}
}
