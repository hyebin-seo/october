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
		setName(n);
		this.time = t;
		this.pay = p;
	}

	@Override
	int getPay() {
		// 일한시간 * 시간당급여
		return this.time * this.pay;
	}
}

