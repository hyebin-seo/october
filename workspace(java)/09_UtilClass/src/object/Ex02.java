package object;

/*
 * toString() 메서드 재정의
 * - Object 클래스에서 상속 받은 메서드를 유용한 정보가 반환이 되도록 재정의.
 * - 해당 클래스의 멤버 변수가 정보를 가지고 있는데 가지고 있는 데이터가 올바른 값이 담겼는지
 *   혹은 틀리게 담겨져 있는지 확인하고 싶은 경우에 toString() 메서드를 재정의하여 값을 확인할 수 있음.
 */

class Student { // extends Object 가 생략
	
	String name;
	int hakbun;
	
	public Student() { } // 기본 생성자.
	
	public Student(String name, int hakbun) {
		this.name = name;
		this.hakbun = hakbun;
	}
	
	// 학생 정보 확인 메서드
	// void getStudentInfo() {
	// 	System.out.println("학생 이름 : " + name);
	// 	System.out.println("학생 학번 : " + hakbun);
	// }
	
	@Override
		public String toString() {
			return "학생 이름 : "+name+", 학생 학번 : "+hakbun;
		}
	
}

public class Ex02 {

	public static void main(String[] args) {
		
		Student student = new Student("홍길동", 2021031601);
		//student.getStudentInfo(); // 학생 정보 확인 메서드 호출

		// 생성자를 이용해 멤버변수에 넣어놓은 데이터가 올바르게 들어가 있는지 확인하기 위한 메서드
		// 사용자가 임의로 output() 메서드를 사용하는 것보다 toString()을 사용하는 게 안전하고 좋음.
		System.out.println(student.toString());
	}

}
