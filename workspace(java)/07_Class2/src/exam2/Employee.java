package exam2;


public abstract class Employee {  // 추상 클래스

	String name;
	
	
	public Employee() {  }  // 기본 생성자
	
	public Employee(String name) {
		this.name = name;
	}  // 인자 생성자

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// 급여를 계산하는 메서드
	abstract int getPays();   // 추상 메서드
	
}
