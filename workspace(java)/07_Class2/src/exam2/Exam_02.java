package exam2;

import java.util.Scanner;

public class Exam_02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("도형을선택하세요.(1. 원형 / 2. 사각형)");
		
		System.out.print("도형선택 => ");
		
		int menu = sc.nextInt();
		
		if(menu == 1) {
			System.out.print("반지름입력 => ");
			
			Circle circle = new Circle(sc.nextInt());
			
			System.out.println("============================");
			
			System.out.printf("원의 면적 : %.1f\n", circle.findArea());
			
		}else if(menu == 2) {
			
			System.out.print("가로 입력 : ");
			
			int width = sc.nextInt();
			
			System.out.print("세로 입력 : ");
			
			int height = sc.nextInt();
			
			Rectangle rectangle = new Rectangle(width, height);
			
			System.out.println("============================");
			
			System.out.printf("사각형의면적 : %.1f\n", rectangle.findArea());
		
		}else {
			
			System.out.println("잘못 입력하셨습니다.~~~");
		}
		
		sc.close();

	}

}
