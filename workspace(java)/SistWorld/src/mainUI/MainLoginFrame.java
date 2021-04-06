package mainUI;

import java.awt.EventQueue;
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

public class MainLoginFrame {

	private JFrame mainLoginFrame;
	private JPanel mainLoginPanel;
	
	// 환영문구
	JLabel welcomeLb;

	// 아이디
	JLabel idLb;
	JTextField idTf;
	
	// 비밀번호
	JLabel pwdLb;
	JPasswordField pwdPf;

	// 로그인버튼
	JButton loginBt;
	
	// 회원가입 버튼
	JButton joinBt;
	
	// 회원 정보 목록
	MemberDAO memberMap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainLoginFrame window = new MainLoginFrame();
					window.mainLoginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainLoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//멤버 리스트 생성(싱글톤)
		memberMap = MemberDAO.getInstance();
		
		mainLoginFrame = new JFrame();
		mainLoginPanel = new JPanel();
		
		mainLoginFrame.setBounds(100, 100, 1280, 720);
		mainLoginFrame.setResizable(false);
		mainLoginFrame.setLocationRelativeTo(null);//창이 가운데 나오게
		mainLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainLoginFrame.getContentPane().setLayout(null);
		
		mainLoginFrame.setTitle("SistWorld");
		
		mainLoginPanel.setBounds(0, 0, 1280, 720);
		mainLoginPanel.setLayout(null);
		
		welcomeLb = new JLabel("쌍용월드에 오신 것을 환영합니다.");
		welcomeLb.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLb.setBounds(490, 136, 300, 80);

		idLb = new JLabel("아이디 : ", SwingConstants.RIGHT);
		idLb.setBounds(500, 245, 100, 30);
		idTf = new JTextField(10);
		idTf.setBounds(610, 246, 130, 30);
		idTf.setText("admin"); //TODO 임시
			
		pwdLb = new JLabel("비밀번호 : ", SwingConstants.RIGHT);
		pwdLb.setBounds(500, 285, 100, 30);
		pwdPf = new JPasswordField(10);
		pwdPf.setBounds(610, 286, 130, 30);
		pwdPf.setText("admin"); //TODO 임시
		
		loginBt = new JButton("로그인");
		loginBt.setBounds(540, 341, 200, 30);

		joinBt = new JButton("회원가입");
		joinBt.setBounds(540, 381, 200, 30);
		
		mainLoginPanel.add(welcomeLb);
		mainLoginPanel.add(idLb);
		mainLoginPanel.add(idTf);
		mainLoginPanel.add(pwdLb);
		mainLoginPanel.add(pwdPf);
		mainLoginPanel.add(loginBt);
		mainLoginPanel.add(joinBt);
		
		mainLoginFrame.getContentPane().add(mainLoginPanel);
		
		
		// 이벤트 처리
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
//					JOptionPane.showMessageDialog(null, userId+"님! 환영합니다.");
					Member member = dbc.dataOpen(userId);
					memberMap.put(member.getMember_id(),member);
					new HomeFrame(member.getMember_id());
					mainLoginFrame.dispose();
					
				} else {
					// 아이디 비밀번호 체킹 후 일치하지 않으면
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 일치하지 않습니다.","로그인", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		joinBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 회원가입 프레임과 객체 생성할 것
				new JoinFrame();
				
			}
		});
	}

}
