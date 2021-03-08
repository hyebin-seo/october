package classes;

public class Person {
	// 멤버변수
	String name;
	int age;
	boolean marrige;
	int numberOfChild;
	
	String mar = "";
	
	Person() {
		if(marrige) {
			mar = "기혼";
		} else {
			mar = "미혼";
		}
	}
	
	void showPersonInfo() {
		System.out.println("이  름 >>> "   + name);
		System.out.println("나  이 >>> "   + age);
		System.out.println("결혼여부 >>> " + mar);
		System.out.println("자녀 수 >>> "  + numberOfChild);
	}
}
