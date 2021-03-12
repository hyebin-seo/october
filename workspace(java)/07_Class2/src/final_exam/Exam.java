package final_exam;

public class Exam {

	public static void main(String[] args) {
		
		Student student1 = new Student("강혜린", 60000);
		Student student2 = new Student("안형준", 60000);
		
		Bus bus100 = new Bus(100);
		
		Subway subwayGreen = new Subway(2);
		
		student1.takeBus(bus100);
		student2.takeSubway(subwayGreen);
		
		// student1,2 학생에 대한 정보를 출력
		student1.showStudentInfo();
		System.out.println();
		
		student2.showStudentInfo();
		System.out.println();
		
		// bus100에 대한 정보를 출력해 보자.
		bus100.showBusInfo();
		System.out.println();
		
		// subwayGreen에 대한 정보를 출력해 보자.
		subwayGreen.showSubwayInfo();
		System.out.println();
		
	}

}
