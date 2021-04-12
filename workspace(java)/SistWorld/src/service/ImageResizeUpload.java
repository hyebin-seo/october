package service;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import db.DBConnection;
import model.Member;

public class ImageResizeUpload {
	
	private Image imgResize;
	private ImageIcon resizeIcon;
	private String userImgPath;

	public ImageResizeUpload(String flag, String member_id, int width, int height) {

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images File", "jpg", "jpeg", "gif",
				"png");
		chooser.setFileFilter(filter);

		int ret = chooser.showOpenDialog(null);
		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			this.userImgPath = "NotExistFile";
			return;
		} else {
			System.out.println("[iru-chooseFile]:"+chooser.getSelectedFile().getPath());
		}

		String filePath = chooser.getSelectedFile().getPath();
		Image Img = new ImageIcon(filePath).getImage();
		Image ImgResize = Img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		this.imgResize = ImgResize;
		ImageIcon resizeIcon = new ImageIcon(ImgResize);
		this.resizeIcon = resizeIcon;

		// 원본 이미지 파일
		try {
			FileInputStream fis = new FileInputStream(filePath);
			
			//파일명 저장용 난수 발생
			double dValue = Math.random();
			
			//파일 확장자
			int pos = filePath.lastIndexOf(".");
			String ext = filePath.substring(pos + 1);
			
			//원본 이미지 파일이 복사되어 저장될 경로(파일명 난수 발생시켜 임의저장)
			String userImgPath
				= "../SistWorld/data/user/"+member_id+"/"+member_id+flag+"/"
						+member_id+"_"+(int)(dValue * 100000)
						+"."+ext;
			System.out.println("[ImageResizeUpload]:"+userImgPath);
			
			//원본 이미지 파일이 복사되어 저장될 파일
			FileOutputStream fos = new FileOutputStream(userImgPath);

			int readByte;
			
			while(true) {
				readByte = fis.read();
				
				if(readByte == -1) {
					break;
				}

				fos.write(readByte);
			} // while end
			
			// 입출력 객체 닫기
			fos.close();
			fis.close();
			
			System.out.println("[ImageResizeUpload]: 사진 업로드 완료!");
			
			this.userImgPath = userImgPath;

		} catch (IOException ee) {
			ee.printStackTrace();
		}
	}

	public ImageIcon getResizeIcon() {
		return resizeIcon;
	}

	public void setResizeIcon(ImageIcon resizeIcon) {
		this.resizeIcon = resizeIcon;
	}

	public Image getImgResize() {
		return imgResize;
	}

	public void setImgResize(Image imgResize) {
		this.imgResize = imgResize;
	}

	public String getUserImgPath() {
		return userImgPath;
	}

	public void setUserImgPath(String userImgPath) {
		this.userImgPath = userImgPath;
	}
	
	
}
