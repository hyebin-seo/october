package model;

public class StudentDTO {

	private int hakbun;
	private String name;
	private String major;
	private String phone;
	private String address;
	
	public int getHakbun() {
		return hakbun;
	}
	
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
}
