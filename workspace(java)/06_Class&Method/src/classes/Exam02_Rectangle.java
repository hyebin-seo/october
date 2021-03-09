package classes;

import java.util.Scanner;

public class Exam02_Rectangle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("사각형의 가로, 세로를 입력하세요.");
		Rectangle rectangle = new Rectangle(sc.nextInt(), sc.nextInt());
		System.out.println("==========================");
		
		System.out.println("사각형의 넓이 : " + rectangle.area());
		System.out.println("사각형의 둘레 : " + rectangle.circum());
		
		sc.close();
	}

}
