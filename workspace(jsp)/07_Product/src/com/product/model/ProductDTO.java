package com.product.model;

// products 테이블의 컬럼과 동일하게 멈버변수 구성

public class ProductDTO {
	
	private int pnum;                // 제품 번호
	private String category_fk;      // 카테고리
	private String products_name;    // 제품명
	private String ep_code_fk;       // 제품 코드
	private int input_price;         // 입고가
	private int output_price;        // 출고가
	private int trans_cost;          // 배송 비용
	private int mileage;             // 마일리지
	private String company;          // 제조사
	
	
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getCategory_fk() {
		return category_fk;
	}
	public void setCategory_fk(String category_fk) {
		this.category_fk = category_fk;
	}
	public String getProducts_name() {
		return products_name;
	}
	public void setProducts_name(String products_name) {
		this.products_name = products_name;
	}
	public String getEp_code_fk() {
		return ep_code_fk;
	}
	public void setEp_code_fk(String ep_code_fk) {
		this.ep_code_fk = ep_code_fk;
	}
	public int getInput_price() {
		return input_price;
	}
	public void setInput_price(int input_price) {
		this.input_price = input_price;
	}
	public int getOutput_price() {
		return output_price;
	}
	public void setOutput_price(int output_price) {
		this.output_price = output_price;
	}
	public int getTrans_cost() {
		return trans_cost;
	}
	public void setTrans_cost(int trans_cost) {
		this.trans_cost = trans_cost;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	

}
