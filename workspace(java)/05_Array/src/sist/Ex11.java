package sist;

/*
 * 다차원 배열의 가변배열
 * - java의 다차원 배열은 행마다 서로 다른 열을 가질 수 있다.
 *   행의 크기를 먼저 결정을 하고, 열의 크기는 가변적으로 할당하는 배열.
 * - 가변배열 사용 이유 : 메모리 손실을 최소화 시켜 주기 위함.
 */

public class Ex11 {

	public static void main(String[] args) {
		
		// 1. 다차원 배열의 가변 배열 선언 및 메모리 생성.
		int[][] arr = new int[4][];  // 행 : 4행, 열 : 미지정
		
		// 2. 가변 배열의 열 메모리 생성.
		arr[0] = new int[3];    // 1행 3열
	    arr[1] = new int[2];    // 2행 2열
	    arr[2] = new int[1];    // 3행 1열
        arr[3] = new int[4];    // 4행 4열
        
        // 3. 가변 배열에 초기값 할당.
        int count = 10;
        for(int i=0; i<arr.length; i++) {
        	for(int j=0; j<arr[i].length; j++) {
        		arr[i][j] = count;
        		System.out.print(arr[i][j] + "\t");
        		count += 10;   // count = count + 10;
        	}
        	System.out.println();
        }
	}

}










