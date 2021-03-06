package sist;

// 국어, 영어, 수학, 자바 점수를 키보드로 입력 받아 성적을 처리해 보자.(총점, 평균)

public class Exam_01 {

	public static void main(String[] args) {
		
		// 1. 키보드로 국어, 영어, 수학, 자바 점수를 입력 받자.
		String name = args[0]; //이름을 키보드로 입력
		int kor  = Integer.parseInt(args[1]); //국어 점수 키보드로 입력
		int eng  = Integer.parseInt(args[2]); //영어 점수 키보드로 입력
		int math = Integer.parseInt(args[3]); //수학 점수 키보드로 입력
		int java = Integer.parseInt(args[4]); //자바 점수 키보드로 입력
		
		// 2. 국어 + 영어 + 수학 + 자바 점수 ==> 총점
		int total = kor + eng + math + java;

		// 3. 총점 / 과목 수 ==> 평균
		float avg = total / 4.0f ;
		
		// 4. 화면에 성적을 출력해 주자.
		System.out.println("이름 : " + name);
		System.out.println("국어 : " + kor   + "점");
		System.out.println("영어 : " + eng   + "점");
		System.out.println("수학 : " + math  + "점");
		System.out.println("자바 : " + java  + "점");
		System.out.println("총점 : " + total + "점");
		System.out.printf("평균 : %.2f점\n", avg);

	}

}
