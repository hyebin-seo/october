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

public class Home implements ActionListener{

	// 홈 프레임
	private JFrame mainFrame;
	
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

	// 스킨 간단 변경 & 뮤직 패널
	private	JPanel eastPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Home() {
       
		initialize();
		
	}

	private void initialize() {
		
		// 메인 패널 선언
		mainFrame = new JFrame();
		backPane = new JPanel(); // 홈 카드 레이아웃
		
        // 홈 메인 메뉴 버튼 패널
        menuPane = new MenuPane(backPane);
        mainFrame.getContentPane().add(menuPane);

		// 홈 메인 카드 패널 홈/다이어리/사진첩/방명록/관리
		homePane = new HomePane();
		diaryPane = new DiaryPane();
		galleryPane = new GalleryPane();
		bookPane = new BookPane();
		settingPane = new SettingPane(backPane, menuPane, backImgPane);
		
		// 메인 프레임 설정
		mainFrame.setResizable(false);
		mainFrame.setBounds(100, 100, 1280, 720);
		mainFrame.setLocationRelativeTo(null);//창이 가운데 나오게
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);

		// 배경 패널 설정
		backPane.setBounds(40, 40, 910, 600);
		mainFrame.getContentPane().add(backPane);
		backPane.setLayout(new CardLayout(0, 0));
		backPane.add(homePane, "home");
		backPane.add(diaryPane, "diary");
		backPane.add(galleryPane, "gallery");
		backPane.add(bookPane, "book");
		backPane.add(settingPane, "setting");
		
		// 스킨 간단 변경 & 뮤직 패널
		eastPane = new JPanel();
		eastPane.setBackground(Color.WHITE);
		eastPane.setBounds(1080, 40, 160, 200);
		mainFrame.getContentPane().add(eastPane);
		
		// 홈 타이틀 라벨
		titleLb = new JLabel("SSangYongWorld");
		titleLb.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 16));
		titleLb.setBounds(300, 9, 342, 26);
		mainFrame.getContentPane().add(titleLb);
		
		// 홈 투데이 라벨
		todayLb = new JLabel("TODAY      | TOTAL      ");
		todayLb.setHorizontalAlignment(SwingConstants.CENTER);
		todayLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		todayLb.setBounds(40, 10, 260, 26);
		mainFrame.getContentPane().add(todayLb);
		
		// 홈 로그아웃 버튼
		logOutBt = new RoundedButton("LogOut");
		logOutBt.setBounds(1150, 250, 90, 30);
		mainFrame.getContentPane().add(logOutBt);
        
        // 메인 프레임 배경화면 설정(패널 우선순위 때문에 제일 뒤로 옴)
        backImgPane = new JPanel(){
        	Image background = new ImageIcon(getClass().getResource("../images/back.jpg")).getImage();
        	public void paint(Graphics g) {//그리는 함수
        			g.drawImage(background, 0, 0, null);//background를 그려줌
        	}
        };
        
        backImgPane.setBounds(0, 0, 1280, 720);
        mainFrame.getContentPane().add(backImgPane);

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
