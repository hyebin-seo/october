package sist;

/*
 * [문제6]
 * 1
 * 2	3
 * 4	5	6
 * 7	8	9	10
 * 11	12	13	14	15
 * 
 */

public class Exam_06_01 {

	public static void main(String[] args) {
		// 1. 2차원 배열 선언 및 메모리 할당
		int[][] arr = new int[5][5];
		int count = 1;
		
		// 2. 5행 5열 다차원 배열에 데이터를 저장 하자.
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<i+1; j++) {
				arr[i][j] = count++;
			}
		}
		
		// 3. 다차원 배열을 화면에 출력해 보자.
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				String value = arr[i][j] == 0 ? "" : ""+arr[i][j];
				System.out.print(value+"\t");
			}
			System.out.println();
		}

	}

}
