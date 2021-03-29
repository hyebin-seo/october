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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Home implements ActionListener{

	// 메인 프레임
	private JFrame mainFrame;
	
	// 홈 카드 레이아웃
	private JPanel backPane;
	
	// 홈페이지 타이틀 라벨
	private JLabel titleLb;
	
	// 홈 메인 메뉴 버튼 패널
	private	JPanel menuPane;
	
	// 홈 메인 메뉴 버튼
	private RoundedButton homeBt;
	private RoundedButton diaryBt;
	private RoundedButton gallaryBt;
	private RoundedButton visitorBt;
	private RoundedButton settingBt;
	
	// 홈 메인 카드 레이아웃 패널 홈/다이어리/사진첩/방명록/관리
	private HomePane homePane;
	private JPanel diaryPane;
	private GalleryPane galleryPane;
	private JPanel visitorPane;
	private SettingPane settingPane;
	
	// 홈 메인 타이틀
	private JLabel todayLb;
	
	// 홈 로그아웃 버튼
	private JButton logOutBt;

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

		// 홈 메인 카드 패널 홈/다이어리/사진첩/방명록/관리
		homePane = new HomePane();
		diaryPane = new JPanel();
		galleryPane = new GalleryPane();
		visitorPane = new JPanel();
		settingPane = new SettingPane();
		
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
		backPane.add(visitorPane, "visitor");
		backPane.add(settingPane, "setting");
		homePane.setBackground(Color.GRAY);
		diaryPane.setBackground(Color.GRAY);
		galleryPane.setBackground(Color.GRAY);
		visitorPane.setBackground(Color.GRAY);
		settingPane.setBackground(Color.GRAY);
		
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
		logOutBt = new JButton("LogOut");
		logOutBt.setBounds(1150, 250, 90, 30);
		mainFrame.getContentPane().add(logOutBt);
        
        // 홈 메인 메뉴 버튼 패널
        menuPane = new JPanel();
        menuPane.setBounds(950, 50, 80, 252);
        menuPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        menuPane.setBackground(new Color(255,0,0,0));
        mainFrame.getContentPane().add(menuPane);
        menuPane.setLayout(null);
        
        // 홈 메인 메뉴 버튼
        homeBt = new RoundedButton("Home");
        homeBt.setHorizontalAlignment(SwingConstants.LEFT);
        homeBt.setBounds(0, 0, 80, 50);
        homeBt.addActionListener(this);
        menuPane.add(homeBt);
        
        diaryBt = new RoundedButton("Diary");
        diaryBt.setHorizontalAlignment(SwingConstants.LEFT);
        diaryBt.setBounds(0, 50, 80, 50);
        diaryBt.addActionListener(this);
        menuPane.add(diaryBt);
        
        gallaryBt = new RoundedButton("Gallery");
        gallaryBt.setHorizontalAlignment(SwingConstants.LEFT);
        gallaryBt.setBounds(0, 100, 80, 50);
        gallaryBt.addActionListener(this);
        menuPane.add(gallaryBt);
        
        visitorBt = new RoundedButton("Visitor");
        visitorBt.setHorizontalAlignment(SwingConstants.LEFT);
        visitorBt.setBounds(0, 150, 80, 50);
        visitorBt.addActionListener(this);
        menuPane.add(visitorBt);
        
        settingBt = new RoundedButton("Setting");
        settingBt.setHorizontalAlignment(SwingConstants.LEFT);
        settingBt.setBounds(0, 200, 80, 50);
        settingBt.addActionListener(this);
        menuPane.add(settingBt);
        
        // 메인 프레임 배경화면 설정(패널 우선순위 때문에 제일 뒤로 옴)
        JPanel backImgPane = new JPanel(){
        	Image background = new ImageIcon
        			(Home.class.getResource("../image/back.jpg")).getImage();
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
				break;
				
			case "Diary":
				c1.show(backPane,"diary");		
				break;
						
			case "Gallery":
				c1.show(backPane,"gallery");
				break;
				
			case "Visitor":
				c1.show(backPane,"visitor");
				break;
				
			case "Setting":
				c1.show(backPane,"setting");
				break;
	
			default:
				break;
		}

	}

}
