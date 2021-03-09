package classes;

import java.util.Scanner;

public class Exam05_Receipt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("품목 갯수를 설정하세요.  : ");
		Receipt[] rec = new Receipt[sc.nextInt()];
		
		for(int i=0; i<rec.length; i++) {
			System.out.println("품명, 단가, 수량을 입력하세요.");
			rec[i] = new Receipt(sc.next(), sc.nextInt(),sc.nextInt());
			System.out.println("========================");
		}
		
		System.out.println("품명\t단가\t수량\t금액");
		System.out.println("----------------------------------");
		
		for(int i=0; i<rec.length; i++) {
			System.out.print(rec[i].name+"\t"
								+rec[i].danga+"\t"
								+rec[i].ea+"\t");
			System.out.printf("%,d원\n",rec[i].price());
		}
		
		// 총금액 구하기
		int total = 0;
		for(int i=0; i<rec.length; i++) {
			total += rec[i].price();
		}
		
		System.out.println("----------------------------------");
		System.out.printf("공급가액\t\t\t%,d원\n", 
				rec[0].gong(total));
		System.out.printf("부가세  \t\t\t%,d원\n", 
				rec[0].bugase(total, rec[0].gong(total)));
		System.out.println("----------------------------------");
		System.out.printf("청구금액\t\t\t%,d원\n", 
				rec[0].chungu(rec[0].gong(total), rec[0].bugase(total, rec[0].gong(total))));
		
		sc.close();
	
	}

}
