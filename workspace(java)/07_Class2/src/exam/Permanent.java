package exam;

public class Permanent extends Employee{

	int pay;
	int bonus;
	
	public Permanent() {}
	
	public Permanent(int p, int b) {
		this.pay = p;
		this.bonus = b;
	}
	
	public Permanent(String n, int p, int b) {
		setName(n);
		this.pay = p;
		this.bonus = b;
	}

	@Override
	int getPay() {
		// 기본급 + 보너스
		return this.pay + this.bonus;
	}
}
