package sist;

import java.util.Scanner;

// 별을 찍어 보자

public class Ex28 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("별의 최대 갯수를 입력하세요. : ");
		int starCount = sc.nextInt();
		
		if(starCount > 0) {
			int count = 1;
			while(count <= starCount) {
				System.out.print("*");
				count++;
			}
		}
		
		sc.close();

	}

}
