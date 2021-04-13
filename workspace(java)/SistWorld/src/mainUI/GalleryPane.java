package mainUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import db.DBConnection;
import model.Gal_1;
import model.Gal_menu;
import model.Member;

public class GalleryPane extends JPanel {
	
	DBConnection dbc = DBConnection.getInstance(); //#수정

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String menuName = "";
	OpenActionListner oA = new OpenActionListner();
	RoundedButton createBtn;
	// menuId값의 변수 
	int firstVal = 0; 
	int SecondVal = 0;
	int ThirdVal = 0;
	int currentMenu = 0;

	private JFrame frame;

	// 사진첩 목록 패널
	private JPanel photoSidelist;

	// 사진첩 목록 버튼
	private RoundedButton allBtn;
	private RoundedButton firstBtn = null;
	private RoundedButton SecondBtn = null;
	private RoundedButton ThirdBtn = null;
	private RoundedButton handleBtn = null;

	// 사진첩메인 패널
	private JPanel photoMain;
	private JLabel lblNoexist;
	private ButtonGroup bg;

	// 사진 업로드 하는 버튼
	private JFileChooser chooser;
	private RoundedButton uploadBtn;
	private JLabel preLabel;
	private RoundedButton finalUpload;
	private JTextArea uploadText;
	private RoundedButton cancelBtn;
	private JPanel uploadPanel;
	private RoundedButton savePhoto;
	private JPanel prepanel;
	private JPanel showPanel;
	private JLabel showLabel;
	private JLabel showText;
	

	public GalleryPane(Member member) {

		this.setBounds(40, 40, 910, 600);
		setLayout(null);

		// 사진첩 메인 패널 및 라벨,checkbox
		photoMain = new JPanel();
		photoMain.setBorder(new LineBorder(Color.gray, 1));
		photoMain.setBounds(260, 0, 650, 600);
		photoMain.setBackground(Color.WHITE);
		this.add(photoMain);
		photoMain.setLayout(null);

		lblNoexist = new JLabel("등록된 게시물이 없습니다!!");
		lblNoexist.setBounds(197, 226, 265, 65);
		lblNoexist.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNoexist.setFont(new Font("굴림", Font.PLAIN, 20));
		photoMain.add(lblNoexist);

		showPanel = new JPanel();
		showPanel.setBounds(12, 81, 626, 401);
		showPanel.setBorder(new LineBorder(Color.gray, 1));
		photoMain.add(showPanel);
		showPanel.setLayout(null);

		showLabel = new JLabel("");
		showLabel.setBounds(0, 0, 626, 360);
		showLabel.setBorder(new LineBorder(Color.gray, 1));
		showPanel.add(showLabel);

		showText = new JLabel("");
		showText.setBounds(0, 361, 626, 41);
		showText.setBorder(new LineBorder(Color.gray, 1));
		showPanel.add(showText);

		uploadBtn = new RoundedButton("업로드");
		uploadBtn.setBounds(559, 47, 91, 23);
		uploadBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		photoMain.add(uploadBtn);
		uploadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				uploadText.setText(null);
				uploadPanel.setVisible(true);
				photoMain.setVisible(false);
			}
		});

		// 사진 업로드 버튼
		uploadPanel = new JPanel();
		uploadPanel.setBounds(260, 0, 650, 600);
		uploadPanel.setBackground(Color.white);
		add(uploadPanel);
		uploadPanel.setLayout(null);
		uploadPanel.setVisible(false);

		prepanel = new JPanel();
		prepanel.setBounds(12, 10, 626, 414);
		uploadPanel.add(prepanel);
		prepanel.setLayout(null);

		savePhoto = new RoundedButton("Click!!!");
		savePhoto.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		savePhoto.setBounds(0, 0, 77, 23);
		prepanel.add(savePhoto);

		preLabel = new JLabel("");
		preLabel.setBounds(12, 44, 602, 360);
		prepanel.add(preLabel);

		finalUpload = new RoundedButton("저장");
		finalUpload.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		finalUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// src에 사진데이터 저장
				
				File f = chooser.getSelectedFile();
				double dValue = Math.random(); // 난수발생
				int ran = (int) (dValue * 100000); //#수정
				//#수정 경로가 상대경로가 아니어서 파일이 저장되지 않아 수정합니다.
				oA.fileSave(f, "../SistWorld/data/user/"+member.getMember_id(), f.getName(), ran); // 데이터저장
				
				Gal_1 gallery = new Gal_1();
				Gal_menu gall = new Gal_menu();

				String splitData[] = f.getName().split("\\.");
				String fileName = splitData[0];
				String ext = splitData[1];

				gallery.setGal_content(uploadText.getText());
				gallery.setNew_file_name(fileName + "_" + ran);
				gallery.setOld_file_name(fileName);
				gallery.setFile_ext(ext);
				gallery.setMenu_id(currentMenu);

				int result = dbc.insertGallery(gallery);
				if (result > 0) {
					System.out.println("데이터 추가");
				} else {
					System.out.println("데이터추가 실패!");
				}
				
				gallery = dbc.selectGallery(currentMenu);
				ImageIcon icon = new ImageIcon("../SistWorld/data/user/"+member.getMember_id()+"/" + gallery.getNew_file_name()
						+ "." + gallery.getFile_ext());
				Image img = icon.getImage();
				Image ImgResize = img.getScaledInstance(showLabel.getWidth(), showLabel.getHeight(),
						Image.SCALE_SMOOTH);
				ImageIcon resizeIcon = new ImageIcon(ImgResize);
				showLabel.setIcon(resizeIcon);// 게시물 사진 추가 로직
				showText.setText(gallery.getGal_content());

				lblNoexist.setVisible(false);
				uploadPanel.setVisible(false);
				photoMain.setVisible(true);
				preLabel.setIcon(null);

			}

		});

		finalUpload.setBounds(431, 0, 91, 23);
		prepanel.add(finalUpload);

		cancelBtn = new RoundedButton("취소");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				photoMain.setVisible(true);
				uploadPanel.setVisible(false);
				preLabel.setIcon(null);
				uploadText.setText(null);

			}
		});
		cancelBtn.setBounds(534, 0, 91, 23);
		prepanel.add(cancelBtn);

		uploadText = new JTextArea();
		uploadText.setBorder(new LineBorder(Color.gray, 1));
		uploadText.setLineWrap(true);
		uploadText.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		uploadText.setForeground(Color.LIGHT_GRAY);
		uploadText.setBounds(12, 431, 626, 159);
		uploadPanel.add(uploadText);
		savePhoto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // 사진 이미지 불러오는 메서드
				chooser = new JFileChooser("c:");

				FileNameExtensionFilter filter = new FileNameExtensionFilter("Images File", "jpg", "jpeg", "gif",
						"png");
				chooser.setFileFilter(filter);

				int ret = chooser.showOpenDialog(null);
				if (ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택하지않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
					return;
				} else {
					String filePath = chooser.getSelectedFile().getPath();
					Image img = new ImageIcon(filePath).getImage();
					Image ImgResize = img.getScaledInstance(preLabel.getWidth(), preLabel.getHeight(),
							Image.SCALE_SMOOTH);
					ImageIcon resizeIcon = new ImageIcon(ImgResize);
					preLabel.setIcon(resizeIcon);
					System.out.println("[GalleyPane-chooseImage]" + chooser.getSelectedFile().getPath());

				}
			}
		});

		// 사진첩 패널 및 목록 버튼
		photoSidelist = new JPanel();
		photoSidelist.setBounds(0, 0, 259, 600);
		photoSidelist.setBorder(new LineBorder(Color.gray, 1));
		photoSidelist.setBackground(Color.white);
		photoSidelist.setForeground(Color.BLACK);
		this.add(photoSidelist);

		RoundedButton AddBtn = new RoundedButton("Add 앨범");
		AddBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		AddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int menuCnt = dbc.selectMenuCnt(member.getMember_id());
				System.out.println("sele>>" + menuCnt);

				if (menuCnt >= 3) {
					JOptionPane.showMessageDialog(null, "더이상 사진첩 메뉴를 만들 수 없습니다.");
				} else {
					menuName = JOptionPane.showInputDialog("폴더명을 입력하세요.");

					if (!"".equals(menuName)) {
						dbc.insertMenu(menuName, member.getMember_id());
						showSideMenu(member.getMember_id());
						panelRefresh();
					} else {
						System.out.println("메뉴등록에 실패했습니다.");
					}
				}

			}
		});
		photoSidelist.setLayout(null);

		handleBtn = new RoundedButton("폴더삭제 >>");
		handleBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		handleBtn.setBounds(0, 575, 259, 25);
		photoSidelist.add(handleBtn);

		// sidepanel에서 생성된 버튼을 블러처리하는 이벤트
		handleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuName = JOptionPane.showInputDialog("폴더명을 입력하세요.");
				sideMenuDelete(menuName, member.getMember_id());

			}
		});

		showSideMenu(member.getMember_id());

		// sidepanel 버튼(전체보기, Add앨범, firstBtn, SecondBtn, ThirdBtn 이벤트 및 속성)

		allBtn = new RoundedButton();

		allBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		allBtn.setBounds(0, 60, 259, 25);
		photoSidelist.add(allBtn);

		AddBtn.setBounds(0, 0, 83, 25);
		photoSidelist.add(AddBtn);
		bg = new ButtonGroup();

	}

	public void sideMenuDelete(String menuName, String memberId) {
		int menuId = dbc.sideMenuDelete(menuName, memberId);
		
		if (menuId > 0) {
	
			if (menuId == currentMenu) {
				currentMenu = 0;
	
				showGalleryList(currentMenu, memberId);
				showSideMenu(memberId);
				
			} else {
	
				showGalleryList(currentMenu, memberId);
				showSideMenu(memberId);
			}
		} else {
	
			JOptionPane.showMessageDialog(null, "입력하신 폴더명은 존재하지 않습니다!!");
		}
	}

	//#수정
	public void showSideMenu(String memberId) {
		
		try {
			List<Gal_menu> menuList = dbc.showSideMenu(memberId);

			if (menuList.size() > 0) {
				for (int i = 0; i < menuList.size(); i++) {

					if (i == 0) {
						firstBtn = new RoundedButton(menuList.get(i).getMenu_name());
						firstBtn.setBounds(137, 102, 99, 61);
						firstBtn.setVisible(true);
						photoSidelist.add(firstBtn);
						firstVal = menuList.get(i).getMenu_id();
						firstBtn.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								showLabel.setIcon(null);
								showText.setText(null);
								lblNoexist.setVisible(true);
								showGalleryList(firstVal,memberId);
								allBtn.setText(firstBtn.getText());
								currentMenu = firstVal;
							}
						});

					} else if (i == 1) {
						SecondBtn = new RoundedButton(menuList.get(i).getMenu_name());
						SecondBtn.setBounds(12, 193, 99, 61);
						SecondBtn.setVisible(true);
						photoSidelist.add(SecondBtn);
						SecondVal = menuList.get(i).getMenu_id();
						SecondBtn.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								showLabel.setIcon(null);
								showText.setText(null);
								lblNoexist.setVisible(true);
								showGalleryList(SecondVal, memberId);
								allBtn.setText(SecondBtn.getText());
								currentMenu = SecondVal;
							}
						});
					} else if (i == 2) {
						ThirdBtn = new RoundedButton(menuList.get(i).getMenu_name());
						ThirdBtn.setBounds(137, 193, 99, 61);
						ThirdBtn.setVisible(true);
						photoSidelist.add(ThirdBtn);
						ThirdVal = menuList.get(i).getMenu_id();
						ThirdBtn.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								showLabel.setIcon(null);
								showText.setText(null);
								lblNoexist.setVisible(true);
								showGalleryList(ThirdVal, memberId);
								allBtn.setText(ThirdBtn.getText());
								currentMenu = ThirdVal;
							}
						});
					}
				}
				if (currentMenu == 0) {
					currentMenu = firstVal;
					showGalleryList(firstVal, memberId);// 메뉴가 1개 이상일때 default로 첫번째 메뉴 선택됨
				} else {
					showGalleryList(currentMenu, memberId);
				}
				panelRefresh();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showGalleryList(int menuId, String memberId) {
		try {
			List<Gal_1> galList = dbc.showGalleryList(menuId, memberId); //#수정
			
			if (galList.size() > 0) {
				for (int i = 0; i < galList.size(); i++) {
					Gal_1 gal = galList.get(i);
					String path = "";
					ImageIcon icon = new ImageIcon(
							"../SistWorld/data/user/"+memberId+"/" + gal.getNew_file_name() + "." + gal.getFile_ext());
					Image img = icon.getImage();
					Image ImgResize = img.getScaledInstance(showLabel.getWidth(), showLabel.getHeight(),
							Image.SCALE_SMOOTH);
					ImageIcon resizeIcon = new ImageIcon(ImgResize);
					showLabel.setIcon(resizeIcon);// 게시물 사진 추가 로직
					showText.setText(gal.getGal_content());
					lblNoexist.setVisible(false);
				}
			} else {
				showLabel.setIcon(null);
				showText.setText("");
				lblNoexist.setVisible(true);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void panelRefresh() {
		photoSidelist.revalidate();
		photoSidelist.repaint();
	}
}