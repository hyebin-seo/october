package sist;

// 2. 배열의 초기값을 이용하여 배열 생성.

public class Ex04 {

	public static void main(String[] args) {
		
		// 배열을 생성함과 동시에 초기값 설정
		int[] arr = {10, 20, 30, 40, 50};
		
		arr[2] += 50;   // arr[2] = 80;
		
		for(int k : arr) {
			System.out.println("arr 배열 요소 >>> " + k);
		}
	}

}
