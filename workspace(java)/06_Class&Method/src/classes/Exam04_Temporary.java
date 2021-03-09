package classes;

import java.util.Scanner;

public class Exam04_Temporary {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름, 작업시간, 시간당 급여를 입력하세요.");
		Temporary tem = new Temporary(sc.next(),sc.nextInt(),sc.nextInt());
		System.out.println("================================");
		
		System.out.println("이름 : " + tem.name);
		System.out.printf("총급여 : %,d원\n", tem.total());
		System.out.printf("공제액 : %,d원\n", tem.gong(tem.total()));
		System.out.printf("실지급액 : %,d원\n", tem.sil(tem.total(), tem.gong(tem.total())));
		
		sc.close();
		
		// 강사님 코딩
		tem.paySum();
	}

}
