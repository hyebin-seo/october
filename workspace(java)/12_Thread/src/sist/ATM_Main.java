package sist;

/*
 * [ATM 클래스 설계서]
 * - 입금과 출금의 은행거래가 가능한 ATM 공용 클래스 설계.
 * - 계좌잔액 : private int balance;
 * - 생성자 : 계좌잔액(balance) 초기화
 * - deposit() : 외부 클래스에서 입금하는 메서드.
 *   예) balance = balance + money;  // 잔액에 입금액을 더함.
 *       출력문 : OO,OOO원을 입금하여 OO,OOO원이 남음.
 * - withdraw() : 외부 클래스에서 출금하는 메서드.
 *   예) balance = balance - money;  // 잔액에서 출금액을 차감.
 *       출력문 : OO,OOO원을 출금하여 OO,OOO원이 남음.
 *       (단, balance < money 인 경우 "잔액이 부족합니다." 메세지 출력)
 */

/*
 * synchronized 키워드
 * - 스레드 동기화와 관련된 키워드.
 * - 멀티스레드에 의해서 공유된 메서드나 클래스를 대상으로
 *   임계영역(critical section)을 설정.
 * - 임계영역으로 설정된 메서드에서는 가장 먼저 도착한 스레드가
 *   완전히 종료될 때까지 나머지 스레드는 대기하는 명령어.
 * - 공유되는 자원은 대부분 static 키워드를 가진 객체들을 사용함.
 */

class ATM {  // 공용 클래스

	private int balance;    // 계좌 잔액
	
	public ATM() {  }
	
	public ATM(int balance) {
		this.balance = balance;
	}
	
	// 입금하는 메서드
	synchronized void deposit(int money) {
		balance = balance + money;
		System.out.println
			(Thread.currentThread().getName()+"님이 "+
					money+"원을 입금하여 "+balance+"원이 남았습니다.");
	}
	
	// 출금하는 메서드
	synchronized void withdraw(int money) {
		if(money > balance) {
			System.out.println("잔액이 부족합니다.");
			return;  // 현재 실행되고 있는 메서드를 종료하는 명령어.
		}
		
		balance = balance - money;
		System.out.println
		(Thread.currentThread().getName()+"님이 "+
				money+"원을 출금하여 "+balance+"원이 남았습니다.");
	}
	
}

// 스레드를 구현할 클래스
class User extends Thread {
	
	ATM atm;
	
	public User() { }
	
	public User(ATM atm, String name) {
		super(name);
		this.atm = atm;
	}

	
	@Override
	public void run() {
		this.atm.deposit(20000);  // 입금하는 메서드 호출
 		this.atm.withdraw(30000); // 출금하는 메서드 호출
	}
}

public class ATM_Main {

	public static void main(String[] args) {
		
		ATM atm = new ATM(0);
		
		// User 클래스를 대상으로 멀티스레드 객체 생성
		User user1 = new User(atm, "홍길동");
		User user2 = new User(atm, "이순신");
		User user3 = new User(atm, "유관순");
		User user4 = new User(atm, "김유신");
		User user5 = new User(atm, "김연아");
		
		user1.start(); user2.start();
		user3.start(); user4.start(); user5.start();

	}

}
