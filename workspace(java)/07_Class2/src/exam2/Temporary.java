package exam2;

public class Temporary extends Employee {

	// 멤버변수
	int time;                // 작업 시간
 	int pay;                 // 시간당 급여
 	
 	public Temporary() {  }
 	
 	public Temporary(String name, int time, int pay) {
 		this.name = name;
 		this.time = time;
 		this.pay = pay;
 	}
 	
 	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	@Override
	int getPays() {   // 추상메서드 재정의
		
		return time * pay;
		
	}

}
