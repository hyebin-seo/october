package final_exam;

public class Student {

	// 멤버변수
	String  studentName;   //학생이름
	int tMoney;            //학생 교통카드(잔액)
	
	public Student() {	}; //기본생성자
	
	public Student(String studentName, int tMoney) {
		this.studentName = studentName;
		this.tMoney = tMoney;
	} //인자 생성자
	
	//버스를 타고 학교에 가는 경우
	void takeBus(Bus bus) {
		bus.take(1200);
		this.tMoney -= 1200;
	}
	
	//지하철을 타고 학교에 가는 경우
	void takeSubway(Subway subway) {
		subway.take(1250);
		this.tMoney -= 1250;
	}
	
	//학생 정보 출력
	void showStudentInfo() {
		System.out.println(studentName+"님의 카드 잔액은 "+tMoney+"원 입니다.");
	}
}
