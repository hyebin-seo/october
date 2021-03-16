package statics;

/*
 * 싱글턴(singleton) 방식?
 * - 생성자를 private 접근 지정자를 사용하여 외부에서 직접 접근을 못하게 불허하는 방식.
 * - 외부에서 해당 클래스의 인스턴스를 new로 생성하지 못하도록 하는 방식.
 * - 사용하는 이유 : 매번 객체를 생성하게 되면 메모리 성능이 느려지는 단점이 발생하기 때문.
 */

class Company { 
	
	private static Company instance = null;
	
	private Company() { }
	
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}
}

public class Ex01 {

	public static void main(String[] args) {
		
//		Company com1 = new Company();
//		Company com2 = new Company();
//		Company com3 = new Company();
//		Company com4 = new Company();
//		Company com5 = new Company();
//		Company com6 = new Company();
//		Company com7 = new Company();
//		Company com8 = new Company();
//		Company com9 = new Company();
//		Company com10 = new Company();
		
		Company com1 = Company.getInstance();
		Company com2 = Company.getInstance();
		Company com3 = Company.getInstance();
		Company com4 = Company.getInstance();
		Company com5 = Company.getInstance();
		Company com6 = Company.getInstance();
		Company com7 = Company.getInstance();
		Company com8 = Company.getInstance();
		Company com9 = Company.getInstance();
		Company com10 = Company.getInstance();
		
		System.out.println("com1 >>> " + com1);
		System.out.println("com2 >>> " + com2);
		System.out.println("com3 >>> " + com3);
		System.out.println("com4 >>> " + com4);
		System.out.println("com5 >>> " + com5);
		System.out.println("com6 >>> " + com6);
		System.out.println("com7 >>> " + com7);
		System.out.println("com8 >>> " + com8);
		System.out.println("com9 >>> " + com9);
		System.out.println("com10 >>> " + com10);
		

	}

}
