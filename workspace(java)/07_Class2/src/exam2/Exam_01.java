package exam2;

import java.util.Scanner;


public class Exam_01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String pt = "";
		
		System.out.println("고용형태-정규직<P>, 임시직<T>를 입력하세요.");
		
		pt = sc.next();
		
		if(pt.equalsIgnoreCase("P")) {
			pt = "정규직";
			System.out.println("이름, 기본급, 보너스를 입력하세요...");
			Permanent permanent = new Permanent();
			permanent.setName(sc.next());
			permanent.setSalary(sc.nextInt());
			permanent.setBonus(sc.nextInt());
			
			System.out.println("================================");
			System.out.println("고용형태 : " + pt);
			System.out.println("이 름 : " + permanent.getName());
			// 재정의한 메서드
			System.out.printf("급 여 : %,d원\n", permanent.getPays());  
		}else if(pt.equalsIgnoreCase("T")) {
			pt = "임시직";
			System.out.println("이름, 작업시간, 시간당 급여를 입력하세요...");
			Temporary temporary = 
				new Temporary(sc.next(), sc.nextInt(), sc.nextInt());
			
			System.out.println("================================");
			System.out.println("고용형태 : " + pt);
			System.out.println("이 름 : " + temporary.getName());
			// 재정의한 메서드
			System.out.printf("급 여 : %,d원\n", temporary.getPays());
		}else {
			System.out.println("잘못 입력하셨습니다.~~~");
		}
		
		sc.close();


	}

}
