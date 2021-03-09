package classes;

public class Person {
	// 멤버변수
	String name;
	String sex;
	int age;
	boolean marrige;
	int numberOfChild;
	
	String mar = "";
	
	public Person() {
		if(marrige) {
			mar = "기혼";
		} else {
			mar = "미혼";
		}
	}
	
	public Person(String n, String s, int a) {
		name = n;
		sex = s;
		age = a;
		
		if(sex.equals("male")) {
			sex = "남자";
		} else if(sex.equals("female")){
			sex = "여자";
		} else {
			sex = "";
		}
	}
	
	void showPersonInfo() {
		System.out.println("이  름 >>> "   + name);
		System.out.println("나  이 >>> "   + age);
		System.out.println("결혼여부 >>> " + mar);
		System.out.println("자녀 수 >>> "  + numberOfChild);
	}
	
	void showPersonInfo2() {
		System.out.println("이  름 >>> "   + name);
		System.out.println("성  별 >>> "   + sex);
		System.out.println("나  이 >>> "   + age);
	}
}
