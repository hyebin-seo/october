package inheritance;

public class Ex03_Human {

	public static void main(String[] args) {
		
		Student student = new Student();
		student.name = "홍길동";
		student.age = 27;
		student.job = "대학생";
		student.major = "경제학과";
		
		student.studentInfo();
		System.out.println();
		
		Employee employee = new Employee();
		employee.name = "정우석";
		employee.age = 31;
		employee.job = "연예인";
		employee.salary = 10000;
		
		employee.employeeInfo();
		

	}

}
