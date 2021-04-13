 package mainUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenActionListner implements ActionListener {

	JFileChooser chooser = new JFileChooser("c:");
	JLabel finalUpoad = new JLabel();
	OpenActionListner(){
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images File", "jpg", "jpeg", "gif", "png");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}else {
			System.out.println(chooser.getSelectedFile().getPath());
			
			File f = chooser.getSelectedFile();
			//fileSave(f, chooser.getSelectedFile().getPath(), f.getName()); 추후 삭제
			
			
		}
		
		String filePath = chooser.getSelectedFile().getPath();
		finalUpoad.setIcon(new ImageIcon(filePath));
		
	}
	
	public void fileSave(File file, String path, String name, int ran) {
		try {
			File f = new File(path);
			if(!f.isFile()) {
				f.mkdirs();
			}
			
			System.out.println(name);
			String splitData[] =name.split("\\.");
			String fileName = splitData[0];
			String ext = splitData[1];
			String filePath = (path+"\\"+fileName + "_" + ran+"."+ext);
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(filePath);
			
			int i = 0;
			byte[] buffer = new byte[1024];
			
			while((i=fis.read(buffer, 0, 1024)) != -1) {
				fos.write(buffer, 0, i);
			}
			
			fis.close();
			fos.close();
		}catch(Exception e) {
			
		}
	}
}
