package sist;

import java.util.Scanner;

// 배열 공유

public class Ex08 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수형 배열의 크기 입력 : ");
		
		int[] arr = new int[sc.nextInt()];
		
		// 상당히 중요한 개념
     	// 배열 이름은 heap 영역의 주소값을 저장하고 있기 때문에
		// 아래 문장은 주소값을 다른 배열의 배열명에 복사해 주는 명령문이다.
		// 즉, 배열의 공유가 이루어지게 된다.
		int[] arrCopy = arr;
		
		System.out.println(arr);
		System.out.println(arrCopy);
		
		
		// 정수형 배열에 키보드로 정수값을 입력을 하자.
		for(int i=0; i<arr.length; i++) {
			System.out.print((i+1)+"번째 정수 입력 >>> ");
			arr[i] = sc.nextInt();
		}
		
		// 정수형 배열에 저장된 정수값을 출력을 해 보자.
		for(int i=0; i<arr.length; i++) {
			System.out.println("arrCopy["+i+"] >>> "+arrCopy[i]);
		}
		

		sc.close();
		
	}

}
