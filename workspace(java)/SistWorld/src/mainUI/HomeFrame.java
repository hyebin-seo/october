package mainUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import db.DBConnection;
import model.Member;
import service.ImageUpload;
import service.MasterSession;
import service.OwnerCheck;

public class HomeFrame extends JFrame implements ActionListener{

	MasterSession ms = MasterSession.getInstance();
	DBConnection dbc = DBConnection.getInstance();
	
	// 회원 목록
	Member member;
	String member_id;
	
	// 홈 카드 레이아웃
	private JPanel backPane;
	
	// 홈 프로필 패널
	private ProfilePane profilePane;

	// 홈페이지 타이틀 라벨
	private RoundedButton titleMBt;
	private JTextField titleLb;
	
	// 홈 메인 메뉴 버튼 패널
	private	MenuPane menuPane;
	
	// 홈 메인 카드 레이아웃 패널 홈/다이어리/사진첩/방명록/관리
	private HomePane homePane;
	private DiaryPane diaryPane;
	private GalleryPane galleryPane;
	private BookPane bookPane;
	private SettingPane settingPane;
	
	// 홈 로그아웃 버튼
	private RoundedButton logOutBt;
	private SkinLabel backSkinLb;
	
	public void subSetting() {
		logOutBt.setVisible(false);
		titleLb.setEnabled(false);
	}

	public HomeFrame(String member_id) {
		this.member = new OwnerCheck(ms.getMaster_id(),member_id).getMember();
		this.member_id = member_id;
		
		// 메인 패널 선언
		backPane = new JPanel(); // 홈 카드 레이아웃
		
		// 프로필 패널
        profilePane = new ProfilePane(ms.getMaster_id(), member);
        profilePane.setBorder(new LineBorder(new Color(192, 192, 192)));
        profilePane.setBounds(60, 45, 260, 600);
        profilePane.setBackground(Color.WHITE);
        profilePane.setLayout(null);
		
        // 홈 메인 메뉴 버튼 패널
        menuPane = new MenuPane(member, backPane, profilePane);

 
		// 홈 메인 카드 패널 홈/다이어리/사진첩/방명록
        // 관리 패널은 객체 생성 순서때문에 제일 뒤로 감
		homePane = new HomePane(member);
		diaryPane = new DiaryPane(member);
		galleryPane = new GalleryPane(member);
		bookPane = new BookPane(member);
		
		// 메인 프레임 설정
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(0, 0, 1280, 720);
		this.setLocationRelativeTo(null);//창이 가운데 나오게
		if(ms.getMaster_id().equals(member_id)) {
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) { 
            		dbc.close();
            		System.exit(0);
                }
			});
		}
		getContentPane().setLayout(null);
		getContentPane().add(menuPane);
        getContentPane().add(profilePane);

		// 배경 패널 설정
		backPane.setBounds(320, 45, 650, 600);
		getContentPane().add(backPane);
		backPane.setLayout(new CardLayout(0, 0));
		backPane.add(homePane, "home");
		backPane.add(diaryPane, "diary");
		backPane.add(galleryPane, "gallery");
		backPane.add(bookPane, "book");
		
		// 홈 타이틀 변경 버튼
		titleMBt = new RoundedButton();
		titleMBt.setText("확인");
		titleMBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		titleMBt.setBounds(930, 15, 40, 30);
		titleMBt.setVisible(false);
		getContentPane().add(titleMBt);
		titleMBt.addActionListener(this);
		
		// 홈 타이틀 라벨
		titleLb = new JTextField(member.getHome_title());
		titleLb.setForeground(Color.WHITE);
		titleLb.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		titleLb.setBounds(320, 19, 610, 26);
		titleLb.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		titleLb.setEditable(false);
		titleLb.setOpaque(false);
		getContentPane().add(titleLb);
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 2) {
		        	titleLb.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		    		titleLb.setEditable(true);
		    		titleMBt.setVisible(true);

		         }
		    }
		};
		
		
		// 홈 로그아웃 버튼
		logOutBt = new RoundedButton("LogOut");
		logOutBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		logOutBt.setBounds(1130, 615, 90, 30);
		getContentPane().add(logOutBt);
		logOutBt.addActionListener(this);
		
		if(!ms.getMaster_id().equals(member_id)) {
			subSetting();
		} else {
			titleLb.addMouseListener(mouseListener);
		}
 
		// 메인 프레임 배경화면 설정(패널 우선순위 때문에 제일 뒤로 옴)
		// 스킨 경로 DB에서 가져와서 설정값 있으면 변경해줄것
		System.out.println("[HomeFrame]: "+member);
		System.out.println("[HomeFrame-skin path]: " + member.getHome_skin());
		backSkinLb = new SkinLabel(this, member.getHome_skin());
		// 관리 패널 생성(객체 생성 순서때문에 제일 뒤로 옴)
		settingPane = new SettingPane(member, backSkinLb, this, menuPane);
		backPane.add(settingPane, "setting");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout c1 = (CardLayout)backPane.getLayout();
		String btName = e.getActionCommand();
		
		switch (btName) {
			case "Home":
				c1.show(backPane,"home");
				new ImageUpload();
				break;
				
			case "Diary":
				c1.show(backPane,"diary");		
				break;
						
			case "Gallery":
				c1.show(backPane,"gallery");
				break;
				
			case "Visitor":
				c1.show(backPane,"book");
				break;
				
			case "Setting":
				c1.show(backPane,"setting");
				break;
				
			case "LogOut" :
				int num = JOptionPane.showConfirmDialog
						(null, "로그아웃 하시겠습니까?","로그아웃",JOptionPane.YES_NO_OPTION);
		        if(num == JOptionPane.YES_OPTION) {
		        	new LoginFrame();
					dispose();
					break;
				}
				break;
				
			case "확인" :
				int rs = dbc.modifyTitle(titleLb.getText(), ms.getMaster_id());
	    		if(rs > 0) {
	    			titleLb.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	    			titleLb.setEditable(false);
	    			titleMBt.setVisible(false);
	    		}
				break;
			default:
				break;
		}

	}
}
