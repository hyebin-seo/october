package sist;

public class Ex04 {

	public static void main(String[] args) {
		
		// 배열을 생성함과 동시에 초기값 설정
		int[] arr = {10, 20, 30, 40, 50};
		
		arr[2] += 50; // arr[2] = 80;
		
		for(int k : arr) {
			System.out.println("arr 배열 요소 >>> " + k);
		}

	}

}
