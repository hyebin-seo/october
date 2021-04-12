package mainUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Member;
import service.FriendCheck;
import service.ImageUpload;
import service.MasterSession;
import service.OwnerCheck;

public class HomeFrame extends JFrame implements ActionListener{

	MasterSession ms = MasterSession.getInstance();
	
	// 회원 목록
	Member member;
	String member_id;
	
	// 홈 카드 레이아웃
	private JPanel backPane;

	// 홈페이지 타이틀 라벨
	private JLabel titleLb;
	
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
	}

	public HomeFrame(String member_id) {
		MasterSession ms = MasterSession.getInstance();
		this.member = new OwnerCheck(ms.getMaster_id(),member_id).getMember();
		this.member_id = member_id;
		
		// 메인 패널 선언
		backPane = new JPanel(); // 홈 카드 레이아웃
		
        // 홈 메인 메뉴 버튼 패널
        menuPane = new MenuPane(member, backPane);

		// 홈 메인 카드 패널 홈/다이어리/사진첩/방명록
        // 관리 패널은 객체 생성 순서때문에 제일 뒤로 감
		homePane = new HomePane(member);
		diaryPane = new DiaryPane();
		galleryPane = new GalleryPane(member);
		bookPane = new BookPane(member);
		
		// 메인 프레임 설정
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(0, 0, 1280, 720);
		this.setLocationRelativeTo(null);//창이 가운데 나오게
		if(ms.getMaster_id().equals(member_id)) {
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		getContentPane().setLayout(null);
		getContentPane().add(menuPane);

		// 배경 패널 설정
		backPane.setBounds(60, 45, 910, 600);
		getContentPane().add(backPane);
		backPane.setLayout(new CardLayout(0, 0));
		backPane.add(homePane, "home");
		backPane.add(diaryPane, "diary");
		backPane.add(galleryPane, "gallery");
		backPane.add(bookPane, "book");
		
		// 홈 타이틀 라벨
		titleLb = new JLabel(" "+member.getMember_name()+"의 SistWorld!");
		titleLb.setForeground(new Color(9,131,178));
		titleLb.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		titleLb.setBounds(320, 19, 650, 26);
		getContentPane().add(titleLb);
		
		// 홈 로그아웃 버튼
		logOutBt = new RoundedButton("LogOut");
		logOutBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		logOutBt.setBounds(1130, 615, 90, 30);
		getContentPane().add(logOutBt);
		logOutBt.addActionListener(this);
		
		if(!ms.getMaster_id().equals(member_id)) {
			subSetting();
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
			default:
				break;
		}

	}
}
