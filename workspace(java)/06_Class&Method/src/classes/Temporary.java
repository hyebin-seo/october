package classes;

public class Temporary {
	String name;
	int time;
	int pay;
	
	public Temporary() {
		
	}
	
	public Temporary(String n, int t, int p) {
		name = n;
		time = t;
		pay = p;
	}
	
	public int total() {
		return time * pay;
	}
	
	public int gong(int total) {
		return (int) (total * 0.03);
	}
	
	public int sil(int total, int gong) {
		return total - gong;
	}
	
	// 강사님 코딩
	void paySum() {
		
		// 총급여액 = 일한시간(작업 시간) * 시간당  급여
		int total = time * pay;
		
		// 공제액 = 총급여액 * 0.03
		int amount = (int)(total *0.03);
		
		// 실지급액 = 총급여액 - 공제액
		int payable = total - amount;
		
		output(total, amount, payable);
	}
	
	// 급여 계산 후 출력하는 메서드
	void output(int sum, int amount, int payable) {
		System.out.println("이 름 : " + name);
		System.out.printf("총급여 : %,d원\n", sum);
		System.out.printf("공제액 : %,d원\n", amount);
		System.out.printf("실지급액 : %,d원\n", payable);
	}
	

}
