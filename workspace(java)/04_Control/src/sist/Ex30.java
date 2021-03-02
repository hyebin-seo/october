package sist;

import java.util.Scanner;

// 숫자 맞추기 게임

public class Ex30 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*** 숫자 맞추기 게임 ***");
		
		int num = (int)(Math.random() * 99) + 1;
		
		System.out.println("1~99 사이의 숫자 중에서 하나의 숫자를 맞추세요.");
		
		int count = 0; // 몇번 만에 맞추는 지 카운트하는 변수
		
		int no = 0; //키보드로 입력받은 내가 선택한 숫자
		
		while(no != num) { // 내가 입력한 수와 컴퓨터로 받은 난수가 다를 때까지만 반복
			System.out.print("어떤 숫자일까?? >>> ");
			no = sc.nextInt();
			
			if(no > num) {
				System.out.println(no + "보다 더 작은 숫자입니다.");
			} else if(no < num) {
				System.out.println(no + "보다 더 큰 숫자입니다.");
			}
			System.out.println("====================");
			count ++;
		}

		System.out.println("축하합니다! 정답입니다!");
		System.out.println("정답 숫자 >>> " + num);
		System.out.println("정답 소요 횟수 >>> " + count + "번");
		
		sc.close();
	}

}
