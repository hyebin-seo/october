package sist;

/*
 * 무명 클래스(anonymous class)를 이용한 스레드 생성.
 * - 코드의 집중화로 가독성이 높아진다.
 * - 별도의 상속 과정이 필요가 없어진다.
 */

public class Ex04 {

	public static void main(String[] args) {
		
		new Thread() {
			@Override
			public void run() {
				int i = 1;
				while(true) {
					System.out.println("i >>> " + i);
					i++;
				}
			}
		}.start();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				int j = 1;
				while(true) {
					System.out.println("j >>> " + j);
					j++;
				}
				
			}
		}).start();

	}

}
