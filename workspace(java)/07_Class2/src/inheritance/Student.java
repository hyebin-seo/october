package inheritance;

public class Student extends Human{
	
	String major; //학과
	
	void studentInfo() {
		System.out.println("이 름 : " + name);
		System.out.println("나 이 : " + age);
		System.out.println("직 업 : " + job);
		System.out.println("학 과 : " + major);
	}

}
