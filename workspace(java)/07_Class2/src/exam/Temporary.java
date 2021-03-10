package exam;

public class Temporary extends Employee {

	int time;
	int pay;
	
	public Temporary() { }
	
	public Temporary(int t, int p) { 
		this.time = t;
		this.pay = p;
	}
	
	public Temporary(String n, int t, int p) {
		this.name = n;
		this.time = t;
		this.pay = p;
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
	int getPays() {
		// 일한시간 * 시간당급여
		return this.time * this.pay;
	}
}

