package sist;

/*
 * [문제5]
 * 1	6	11	16	21
 * 2	7	12	17	22
 * 3	8	13	18	23
 * 4	9	14	19	24
 * 5	10	15	20	25
 */

public class Exam_05 {

	public static void main(String[] args) {
		// 1. 2차원 배열 선언 및 메모리 할당
		int[][] arr = new int[5][5];
		int count = 1;
		
		// 2. 5행 5열 다차원 배열에 데이터를 저장 하자.
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[j][i] = count++;
			}
		}
		
		// 3. 다차원 배열을 화면에 출력해 보자.
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.printf("%2d\t", arr[i][j]);
			}
			System.out.println();
		}

	}

}
