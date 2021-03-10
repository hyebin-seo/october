package exam;

import java.util.Scanner;

public class Ex01_Employee {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Permanent permanent = new Permanent();
		Temporary temporary = new Temporary();

		System.out.println("고용형태-정규직<P>,임시직<T>를 입력하세요.");
		String employee = sc.next();
		
		if(employee.equals("P")) {
			
			System.out.println("이름, 기본급, 보너스를 입력하세요.");
			permanent.setName(sc.next());
			permanent.setPay(sc.nextInt());
			permanent.setBonus(sc.nextInt());

			System.out.println("=======================");
			System.out.println("고용형태 : 정규직");
			System.out.println("이름 : " + permanent.getName());
			System.out.printf("급여 : %,d원\n", permanent.getPay());
		
		} else if(employee.equals("T")) {
			
			System.out.println("이름, 작업시간, 시간당 급여를 입력하세요.");
			temporary.setName(sc.next());
			temporary.setPay(sc.nextInt());
			temporary.setTime(sc.nextInt());
			
			System.out.println("=======================");
			System.out.println("고용형태 : 임시직");
			System.out.println("이름 : " + temporary.getName());
			System.out.printf("급여 : %,d원\n", temporary.getPay());
		
		} else {
			
			System.out.println("잘못된 입력 입니다.");
		}
		
		sc.close();
	}

}
