package model;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

import mainUI.HomePane;

public class Skin extends ImageIcon{

	// 경로: data/user/userId/image
	private String skinPath;  // skin이 저장되어 있는 경로
	private String id;		   // userID

	public Skin(URL fileURL) {
		super(fileURL);
	}
	
	public Skin(Image img) {
		super(img);
	}
	
	public Skin(Image img, String str) {
		super(img);
		this.skinPath = str;
	}

	public String getskinPath() {
		return skinPath;
	}
	public void setskinPath(String sKIN_PATH) {
		skinPath = sKIN_PATH;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
