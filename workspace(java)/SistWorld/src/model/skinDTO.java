package model;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

import mainUI.HomePane;

public class skinDTO extends ImageIcon{

	// 경로: data/user/userId/image
	private String SKIN_PATH;  // skin이 저장되어 있는 경로
	private String id;		   // userID
	private String selectSkin; // 선택한 스킨 값
	
	public skinDTO(URL fileURL) {
		super(fileURL);
	}
	
	public skinDTO(Image img) {
		super(img);
	}
	
	public String getSKIN_PATH() {
		return SKIN_PATH;
	}
	public void setSKIN_PATH(String sKIN_PATH) {
		SKIN_PATH = sKIN_PATH;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSelectSkin() {
		return selectSkin;
	}
	public void setSelectSkin(String selectSkin) {
		this.selectSkin = selectSkin;
	}
	
	
}
