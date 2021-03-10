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
		this.name = n;
		this.pay = p;
		this.bonus = b;
	}	
	

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	int getPays() {
		// 기본급 + 보너스
		return this.pay + this.bonus;
	}
}
