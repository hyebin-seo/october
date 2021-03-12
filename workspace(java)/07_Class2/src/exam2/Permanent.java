package exam2;

public class Permanent extends Employee {

	// 멤버변수
	int salary;          // 급여
	int bonus;           // 보너스
	
	public Permanent() {  }
	
	public Permanent(String name, int salary, int bonus) {
		this.name = name;
		this.salary = salary;
		this.bonus = bonus;
	}
	
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	int getPays() {   // 추상메서드 재정의
		return salary + bonus;
	}

}
