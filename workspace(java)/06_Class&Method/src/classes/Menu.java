package classes;

public class Menu {

	// 멤버변수
	String name;            // 품명
	int unitPrice;          // 단가
	int count;              // 수량
	
	public Menu() {   }     // 기본 생성자
	
	public Menu(String name, int unitPrice, int count) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.count = count;
	}  // 인자 생성자
	
	
}
