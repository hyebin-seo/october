package mainUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import service.ImageUpload;

public class Home extends JFrame implements ActionListener{

	// 홈 카드 레이아웃
	private JPanel backPane;
	
	// 홈 배경화면(스킨)
	private JPanel backImgPane;
	
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
	
	// 홈 메인 타이틀
	private JLabel todayLb;
	
	// 홈 로그아웃 버튼
	private RoundedButton logOutBt;

	// 스킨 변경 & 뮤직 패널
	private	JPanel eastPane;
	private String basicSkinPath = "../images/back.jpg";
	private BackSkinLabel backSkinLb;

	public Home() {
		// 메인 패널 선언
		backPane = new JPanel(); // 홈 카드 레이아웃
		
        // 홈 메인 메뉴 버튼 패널
        menuPane = new MenuPane(backPane);

		// 홈 메인 카드 패널 홈/다이어리/사진첩/방명록
        // 관리 패널은 객체 생성 순서때문에 제일 뒤로 감
		homePane = new HomePane();
		diaryPane = new DiaryPane();
		galleryPane = new GalleryPane();
		bookPane = new BookPane();
		
		// 메인 프레임 설정
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(100, 100, 1280, 720);
		this.setLocationRelativeTo(null);//창이 가운데 나오게
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.add(menuPane);

		// 배경 패널 설정
		backPane.setBounds(40, 40, 910, 600);
		this.add(backPane);
		backPane.setLayout(new CardLayout(0, 0));
		backPane.add(homePane, "home");
		backPane.add(diaryPane, "diary");
		backPane.add(galleryPane, "gallery");
		backPane.add(bookPane, "book");
		
		// 스킨 간단 변경 & 뮤직 패널
		eastPane = new JPanel();
		eastPane.setBackground(Color.WHITE);
		eastPane.setBounds(1080, 40, 160, 200);
		this.add(eastPane);
		
		// 홈 타이틀 라벨
		titleLb = new JLabel("SSangYongWorld");
		titleLb.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 16));
		titleLb.setBounds(300, 9, 342, 26);
		this.add(titleLb);
		
		// 홈 투데이 라벨
		todayLb = new JLabel("TODAY      | TOTAL      ");
		todayLb.setHorizontalAlignment(SwingConstants.CENTER);
		todayLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		todayLb.setBounds(40, 10, 260, 26);
		this.add(todayLb);
		
		// 홈 로그아웃 버튼
		logOutBt = new RoundedButton("LogOut");
		logOutBt.setBounds(1150, 250, 90, 30);
		this.add(logOutBt);
        
		// 메인 프레임 배경화면 설정(패널 우선순위 때문에 제일 뒤로 옴)
		// 스킨 경로 DB에서 가져와서 설정값 있으면 변경해줄것
		backSkinLb = new BackSkinLabel(this, basicSkinPath);
		// 관리 패널 생성(객체 생성 순서때문에 제일 뒤로 옴)
		settingPane = new SettingPane(backPane, menuPane, backSkinLb);
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
	
			default:
				break;
		}

	}

}
