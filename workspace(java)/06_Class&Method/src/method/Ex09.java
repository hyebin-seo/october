package method;

import java.util.Scanner;

public class Ex09 {
	
	public static int sum2(int k, int e) {
		return k + e;
	}
	
	public static int sum3(int k, int e, int m) {
		return k + e + m;
	}
	
	public static int sum4(int k, int e, int m, int j) {
		return k + e + m + j;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수 입력 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 점수 입력 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 점수 입력 : ");
		int mat = sc.nextInt();
		
		System.out.print("자바 점수 입력 : ");
		int java = sc.nextInt();
		
		System.out.println();
		
		// 2과목 총점 메서드 호출
		System.out.println("2과목 총점 >>> " + sum2(kor, eng));
		
		// 3과목 총점 메서드 호출
		System.out.println("3과목 총점 >>> " + sum3(kor, eng, mat));
		
		// 4과목 총점 메서드 호출
		System.out.println("4과목 총점 >>> " + sum4(kor, eng, mat, java));
		
		sc.close();

	}

}
