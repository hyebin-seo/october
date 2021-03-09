package classes;

public class Ex12_PigSave {

	public static void main(String[] args) {
		
		// 돼지 저금통 객체 생성
		PigSave pig = new PigSave(0);
		
		pig.deposit(3000);   //입금
		pig.deposit(5000);   //입금
		pig.withdraw(2000);  //출금
		pig.withdraw(10000); //출금
		
		//pig.balance = 100000; // 코드상으로는 문제가 없지만 이렇게 접근하면 안됨.

	}

}
