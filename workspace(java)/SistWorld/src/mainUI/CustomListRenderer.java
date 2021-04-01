package mainUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import model.SkinDTO;

// JList 내의 셀 크기 조절 클래스
public class CustomListRenderer implements ListCellRenderer {
	
	String flag;
	
	public CustomListRenderer(String flag) {
		this.flag = flag;
	}

   @Override
   public Component getListCellRendererComponent(JList list, Object value, int index,
        boolean isSelected, boolean cellHasFocus) {

	   if(flag.equals("skin")) {
		   	SkinDTO skd = (SkinDTO) value;
			JLabel skinLabel = new JLabel();
			skinLabel.setIcon(skd);
			skinLabel.setText(skd.getSelectSkin());
			skinLabel.setBorder(new EmptyBorder(3, 3, 3, 0));
			skinLabel.setForeground(new Color(255,0,1));
			skinLabel.setHorizontalTextPosition(JLabel.CENTER);
			skinLabel.setVerticalTextPosition(JLabel.BOTTOM);
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