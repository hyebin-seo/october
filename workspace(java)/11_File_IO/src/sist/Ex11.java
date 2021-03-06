package sist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ex11 {

	public static void main(String[] args) {
		
		// C:/sample/test.txt 파일에 내용을 저장.
		
		try {
			FileWriter fw = new FileWriter("C:/sample/test.txt");
			
			BufferedWriter bw = new BufferedWriter(fw);
		
			bw.write("===========================");
			bw.newLine(); // 다음 줄로 이동
			
			bw.write("안녕하세요.");
			bw.newLine(); // 다음 줄로 이동
			
			bw.write("자바는 즐겁습니다.");
			bw.newLine(); // 다음 줄로 이동
			
			// 입출력 객체 닫기
			bw.close();
			fw.close();
			
			System.out.println("파일 내용 추가 완료!");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
