package mainUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import dao.DBConnection;
import model.Member;

public class JoinFrame extends JFrame{
	private JTextField idTf;
	private JPasswordField pwdTf;
	private JTextField nameTf;
	private JTextField emailTf;
	private JDateChooser dateChooser;
	private JRadioButton female;
	private JRadioButton male;

	public JoinFrame() {
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(0, 0, 300, 500);
		this.setLocationRelativeTo(null);// 창이 가운데 나오게
		getContentPane().setLayout(null);

		JLabel joinTitle = new JLabel("쌍용월드 회원가입");
		joinTitle.setHorizontalAlignment(SwingConstants.CENTER);
		joinTitle.setBounds(73, 1, 147, 52);
		getContentPane().add(joinTitle);
		
		// 아이디
		JLabel idLb = new JLabel("ID :");
		idLb.setBounds(0, 73, 110, 20);
		idLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(idLb);
		
		idTf = new JTextField();
		idTf.setBounds(134, 73, 130, 20);
		getContentPane().add(idTf);
		idTf.setColumns(10);
		
		// 비밀번호
		JLabel pwdLb = new JLabel("PASSWORD :");
		pwdLb.setBounds(0, 125, 110, 20);
		pwdLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(pwdLb);
		
		pwdTf = new JPasswordField(30);
		pwdTf.setBounds(134, 125, 130, 20);
		pwdTf.setColumns(10);
		getContentPane().add(pwdTf);
		
		// 이름
		JLabel nameLb = new JLabel("NAME :");
		nameLb.setBounds(0, 177, 110, 20);
		nameLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(nameLb);
		
		nameTf = new JTextField();
		nameTf.setBounds(134, 177, 130, 20);
		nameTf.setColumns(10);
		getContentPane().add(nameTf);
		
		// 생년월일
		JLabel birthLb = new JLabel("BIRTH :");
		birthLb.setBounds(0, 229, 110, 20);
		birthLb.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(birthLb);

		// jcalendar-1.4.jar 필요
		dateChooser = new JDateChooser();
		dateChooser.setBounds(134, 229, 130, 21);
		dateChooser.setDate(new Date());
		getContentPane().add(dateChooser);
	
		// 성별
		JLabel genderLb = new JLabel("GENDER :");
		genderLb.setHorizontalAlignment(SwingConstants.RIGHT);
		genderLb.setBounds(0, 281, 110, 20);
		getContentPane().add(genderLb);
		female = new JRadioButton("남자");
		female.setBounds(73, -1, 60, 23);
		male = new JRadioButton("여자");
		male.setBounds(8, -1, 60, 23);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(male);
		bg.add(female);
		
		JPanel genderPl = new JPanel();
		genderPl.setBounds(134, 281, 130, 20);
		genderPl.setLayout(null);
		genderPl.add(male);
		genderPl.add(female);
		getContentPane().add(genderPl);
		
		// 이메일
		JLabel emailLb = new JLabel("EMAIL :");
		emailLb.setHorizontalAlignment(SwingConstants.RIGHT);
		emailLb.setBounds(0, 333, 110, 20);
		getContentPane().add(emailLb);
		
		emailTf = new JTextField();
		emailTf.setBounds(134, 333, 130, 20);
		emailTf.setColumns(10);
		getContentPane().add(emailTf);
		
		// 가입버튼
		RoundedButton joinBt = new RoundedButton("가입하기");
		joinBt.setOpaque(false);
		joinBt.setBounds(98, 391, 97, 23);
		getContentPane().add(joinBt);
		
		//회원 가입
		joinBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String member_id = idTf.getText();
				String member_pw = new String(pwdTf.getPassword());
				String member_name = nameTf.getText();
				Date birthOrigin = dateChooser.getDate();
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				String member_birth = format.format(birthOrigin);
				String member_gender = "";
				
				if(male.isSelected()) {
					member_gender = male.getText();
				}else if(female.isSelected()) {
					member_gender = female.getText();
				}
				
				String member_email = emailTf.getText();
				
				Member member = new Member();
				member.setMember_id(member_id);
				member.setMember_pw(member_pw);
				member.setMember_name(member_name);
				member.setMember_birth(member_birth);
				member.setMember_gender(member_gender);
				member.setMember_email(member_email);
				
				DBConnection dbc = DBConnection.getInstance();
				int rs = dbc.join(member);
				
				if(rs > 0) {
					// db에서 성공적으로 유저를 가입 시키면 데이터폴더 생성
					String pathImg = "../SistWorld/data/user/"+member_id+"/"+member_id+"img"; //이미지폴더 경로
					String pathMs = "../SistWorld/data/user/"+member_id+"/"+member_id+"music"; //음악폴더 경로
					File imgFolder = new File(pathImg);
					File msFolder = new File(pathMs);
					System.out.println("[JoinFrame-imgFloderPath]:"+pathImg);
					System.out.println("[JoinFrame-MusicFloderPath]:"+pathMs);

					// 해당 디렉토리가 없을경우 경로까지 자동으로 폴더 생성
					// 이미지 폴더
					if (!imgFolder.exists()) {
						try{
							imgFolder.mkdirs();
						    System.out.println("폴더가 생성되었습니다.");
					    } catch(Exception ec){
					    	ec.getStackTrace();
						}        
				    } else {
						System.out.println("이미 폴더가 생성되어 있습니다.");
					}
					
					// 음악 폴더
					if (!msFolder.exists()) {
						try{
							msFolder.mkdirs();
						    System.out.println("폴더가 생성되었습니다.");
					    } catch(Exception ec){
					    	ec.getStackTrace();
						}        
				    } else {
						System.out.println("이미 폴더가 생성되어 있습니다.");
					}
					
					dispose();
				} else {
					JOptionPane.showMessageDialog(null,
							"가입 실패! 다시 가입 신청해주세요.","회원가입", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});

	
	}
}
