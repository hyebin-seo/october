package mainUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BackSkinLabel extends JLabel{
	BufferedImage img = null;
	JFrame mainFrame;
	
	public BackSkinLabel(JFrame mainFrame, String skinFilePath) {
		this.mainFrame = mainFrame;
		
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		
		skinSetting(skinFilePath);

	}
	
	public void skinSetting(String skinFilePath) {
		
		try {
			System.out.println("[BackSkinLabel-Current Skin]: "+skinFilePath);
			img = ImageIO.read(getClass().getResource(skinFilePath));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
			System.exit(0);
		}

		this.setIcon(new ImageIcon(img));
        mainFrame.getContentPane().add(this);
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
		
	}
	
	

}

