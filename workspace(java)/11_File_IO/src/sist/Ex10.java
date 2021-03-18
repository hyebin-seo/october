package sist;

import java.io.File;
import java.io.IOException;

/*
 * File 클래스
 * - 파일 및 디렉토리(폴더)를 만들어 주는 클래스.
 * - 파일 입출력 시에 사용이 됨.
 * - 파일 디렉토리에 대한 경로명, 크기, 타입, 수정 날짜 등의 속성을 제공함.
 *   또한 파일 삭제, 디렉토리 생성, 파일 이름 변경, 디렉토리 내의 파일 리스트 제공 등 다양한 파일 관리 작업을 지원함.
 */

public class Ex10 {

	public static void main(String[] args) {
		// C:/sample 폴더를 만들어 보자.
		File dir = new File("C:/sample");
		
		// 해당 디렉토리가 존재하지 않을 때만 생성
		if(!dir.exists()) {
			dir.mkdir(); // 실제로 폴더를 만들어 주는 메서드.
		}
		
		// C:/sample/test.txt 파일을 만들어 보자
		// 형식) new File(폴더 경로, "파일명")
		File file = new File(dir, "test.txt");
		
		// 해당 파일이 존재하지 않을 때만 생성
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 실제로 파일을 만들어주는 메서드
			System.out.println("파일 생성!");
		}
		
		
	}

}
