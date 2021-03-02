package sist;

import java.util.Scanner;

public class Ex22 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1. 키보드로 이름, 국어점수, 영어점수, 수학점수, 자바점수 입력 받자.
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		System.out.print("국어 점수를 입력하세요 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 점수를 입력하세요 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 점수를 입력하세요 : ");
		int mat = sc.nextInt();
		
		System.out.print("자바 점수를 입력하세요 : ");
		int jav = sc.nextInt();
		

		// 2. 총점을 구하자.
		int sum = kor + eng + mat + jav;
		
		// 3. 평균을 구하자.
		float avg = sum / 4.0f;
		
		// 4. 학점을 구하자.
		String grade; // 학점을 저장할 변수
		
		/*if(avg >= 90) {
			if(avg >= 95) {
				grade = "A+";
			} else {
				grade = "A";
			}
		} else if(avg >= 80 && avg < 90) {
			grade = "B";
		} else if (avg >= 70) {
			grade = "C";
		} else if (avg >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}*/
		
		switch ((int)(avg/10)) {
		case 10 :
		case 9  :
			grade = "A";
			break;
		case 8  :
			grade = "B";
			break;
		case 7  :
			grade = "C";
			break;
		case 6  :
			grade = "D";
			break;
		default :
			grade = "F";
			break;
		}
		
		// 5. 성적을 화면에 출력해 보자.
		System.out.println("이름 : " + name);
		System.out.println("국어 : " + kor + "점");
		System.out.println("영어 : " + eng + "점");
		System.out.println("수학 : " + mat + "점");
		System.out.println("자바 : " + jav + "점");
		System.out.println("총점 : " + sum + "점");
		System.out.printf("평균 : %.2f점\n", avg);
		System.out.println("학점 : " + grade + "학점");
		
		sc.close();

	}

}
