package util;

import java.util.Arrays;

/*
 * 4. Arrays 클래스
 *    - 배열 객체를 처리해주는 클래스.
 */

public class Ex04 {

	public static void main(String[] args) {
		
		String[] str = {"홍길동", "이순신", "유관순"};
		
		for(String k : str) {
			System.out.println("str1 배열 요소 >>> " + k);
		}
		System.out.println();
		
		// 1.fill() : 배열의 요소를 특정한 값(데이터)으로 채우는 메서드.
		Arrays.fill(str, "김유신"); // str이란 배열에 "김유신"데이터로 다 채워라.
		
		for(String k : str) {
			System.out.println("str2 배열 요소 >>> " + k);
		}
		System.out.println();
		
		String[] str2 = {"김유신", "김유신", "강감찬"};
		
		// 2.equals(객체, 객체) : 두 객체의 내용(데이터)이 같은지 틀린지 비교하는 메서드.  
		//                     ==> return 값이 boolean형(true, false)
		//                     ==> 객체의 방 마다 모든 데이터가 같아야만 true.
		if(Arrays.equals(str, str2)) {
			System.out.println("두 객체의 내용(데이터)은 같습니다.");
		} else {
			System.out.println("두 객체의 내용(데이터)은 다릅니다.");
		}
		System.out.println();
		
		// 3.sort() : 배열의 원소(데이터)를 정렬(오름차순)하는 메서드.
		int[] arr = {54, 67, 13, 97, 41};
		
		for(int k : arr) {
			System.out.print(k + "\t");
		}
		System.out.println();
		
		Arrays.sort(arr); //오름차순 정렬
		
		for(int k : arr) {
			System.out.print(k + "\t");
		}
		System.out.println();
		
		
	}

}
