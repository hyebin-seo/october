package sist;

import java.util.Scanner;

/*
 * [문제] 키보드로 학생 수와 이름, 국어점수, 영어점수, 수학점수
 *       배열에 저장 후 총점, 평균, 학점, 석차 배열에 성적을
 *       처리한 후 화면에 아래와 같이 출력되도록 하세요.
 */

public class Exam_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생 수를 입력하세요. : ");
		
		// 1. 학생 이름, 국어 점수, 영어 점수, 수학 점수
		//    총점, 평균, 학점, 순위 배열이 필요하다.
		String[] name = new String[sc.nextInt()];
		System.out.println("**********************");
		int[] kor = new int[name.length];
		int[] eng = new int[name.length];
		int[] mat = new int[name.length];
		int[] tot = new int[name.length];
		double[] avg = new double[name.length];
		String[] grade = new String[name.length];
		int[] rank = new int[name.length];
		
		// 2. 학생 수만큼 이름, 국어점수, 영어점수, 수학점수를
		//    키보드로 입력을 받아서 각각의 배열에 저장을 해 주자.
		for(int i=0; i<name.length; i++) {
			
			//// 이름과 각 과목의 점수 배열에 저장 ////
			System.out.print("학생 이름 입력 : ");
			name[i] = sc.next();
			
			System.out.print("국어 점수 입력 : ");
			kor[i] = sc.nextInt();
			
			System.out.print("영어 점수 입력 : ");
			eng[i] = sc.nextInt();
			
			System.out.print("수학 점수 입력 : ");
			mat[i] = sc.nextInt();
			
			System.out.println("**********************");
			
			//// 총점과 평균과 학점 구하기 ////
			// 총점
			tot[i] = kor[i] + eng[i] + mat[i];
			
			// 평균
			avg[i] = tot[i] / 3.0;
			
			// 학점
			if(avg[i] >= 90) {
				grade[i] = "A학점";
			} else if(avg[i] >= 80) {
				grade[i] = "B학점";
			} else if(avg[i] >= 70) {
				grade[i] = "C학점";
			} else if(avg[i] >= 60) {
				grade[i] = "D학점";
			} else {
				grade[i] = "F학점";
			}
			
			// 석차
			// 모든 학생은 본인이 1등이라고 생각한다.
			rank[i] = 1;
		}
		
		// 진짜로 석차 구한다.
		for(int i=0; i<rank.length; i++) {
			for(int j=0; j<rank.length; j++) {
				if(tot[i] < tot[j]) {
					// 총점이 다음 사람보다 적으면 내 등수가 1++
					rank[i]++; 
				}
			}
		}
		
		// 출력
		for(int i=0; i<name.length; i++) {
			System.out.println("===============================================================");
			System.out.print("이 름 : " + name[i] + " | ");
			System.out.print("총 점 : " + tot[i] + "점 | ");
			System.out.printf("평 균 : %.2f점 | ", avg[i]);
			System.out.print("학 점 : " + grade[i] + " | ");
			System.out.print("석 차 : " + rank[i] + "등");
			System.out.println();
		}
		
		sc.close();

	}

}
