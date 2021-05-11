package com.product.model;

public class CategoryDTO {

	private int cnum;                   // 카테고리 번호
	private String category_code;       // 카테고리 코드
	private String category_name;       // 카테고리 이름
	
	
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	
}
