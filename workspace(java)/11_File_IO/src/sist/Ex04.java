package sist;

import java.io.IOException;
import java.io.InputStreamReader;

/*
 * java 스트림의 종류
 * 1. 바이트 스트림 관련 클래스
 *    - 바이트 스트림 방식으로 데이터를 입출력하는 클래스.
 *      ==> xxxInputStram / xxxOutputStream
 * 2. 문자 스트림 관련 클래스
 *    - 문자 스트림 방식으로 데이터를 입출력하는 클래스.
 *      ==> xxxReader / xxxWriter
 * 3. 바이트 스트림 -> 문자 스트림으로 변환하는 클래스
 *    ==> InputStreamReader / OutputStreamWriter
 */

/*
 * 보조스트림 관련 클래스
 * - 스트림의 기능(속도)를 향상시키는 클래스
 * - Bufferedxxx : 버퍼를 제공하는 보조스트림
 * - 버퍼(buffer) : CPU와 I/O간이 속도 차이를 보관.
 */

public class Ex04 {

	public static void main(String[] args) {
		
		System.out.println("입력 후 끝이라고 입력하세요...");

		InputStreamReader isr = new InputStreamReader(System.in);
		
		int readByte;
		
		try {
			while(true) {
				readByte = isr.read();
				if(readByte == '끝') {
					break;
				}
				System.out.print((char)readByte);
			} // while end.
			// while문 흐름 : true로 무한 루프를 돌면서 reader로 받은 값을 차례대로 비교 후 출력을 반복하다가 비교한 값이 '끝'이면 break한다.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				// 입출력 스트림은 닫아주는 것이 좋다.
				isr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
