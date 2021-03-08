package classes;

public class Ex04_Student {

	public static void main(String[] args) {
		
		// 기본생성자로 객체 생성
		Student student1 = new Student();
		student1.hakbun = 20210001;
		student1.name = "홍길동";
		student1.major = "경제학과";
		student1.addr = "서울시 마포구";
		
		student1.display();
		System.out.println();
		
		// 인자생성자로 객체 생성
		Student student2 = new Student(20210002, "유관순", "회계학과", "충남 천안시");
		student2.display();
		System.out.println();
		
	}

}
