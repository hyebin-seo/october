package mainUI;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.border.BevelBorder;

import model.skinDTO;

// JList 내의 셀 크기 조절(글 줄바꿈) 클래스
public class CustomListRenderer implements ListCellRenderer {
	
	String flag;
	
	public CustomListRenderer(String flag) {
		this.flag = flag;
	}

   @Override
   public Component getListCellRendererComponent(JList list, Object value, int index,
        boolean isSelected, boolean cellHasFocus) {

	   if(flag.equals("skin")) {
			JLabel skinLabel = new JLabel();
			skinLabel.setIcon((skinDTO) value);
//			skinLabel.setText("라벨");
			return skinLabel;
	   } else if(flag.equals("cmt")) {
			JTextArea renderer = new JTextArea(3,10);
			renderer.setText(value.toString());
			renderer.setLineWrap(true);
			return renderer;
	   } else {
		   
	   }
	   return null;
   }
 
}