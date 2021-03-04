package sist;

public class Exam_06_02 {

	public static void main(String[] args) {
		
		int[][] arr = new int[5][];
		int count = 1;
		
		// 1. 가변 배열의 크기를 지정해주자.
		for(int i=0; i<arr.length; i++) {
			 arr[i] = new int[i+1];
		}
		
		// 2. 가변 배열에 데이터를 저장해 주자.
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = count++;
			}
		}
		
		// 3. 가변 배열을 화면에 출력해 보자.
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.printf("%2d\t", arr[i][j]);
			}
			System.out.println();
		}

	}

}
