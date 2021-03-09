package classes;

public class NameCard {
	String name;
	String phone;
	String addr;
	String job;
	
	public NameCard() { }
	
	public NameCard(String n, String p, String a, String j) {
		name = n;
		phone = p;
		addr = a;
		job = j;
	}
	
	public void showInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phone);
		System.out.println("주소 : " + addr);
		System.out.println("직급 : " + job);
	}
	
}
