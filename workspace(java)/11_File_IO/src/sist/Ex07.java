package sist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex07 {

	public static void main(String[] args) {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr); // 보조 스트림을 연결한다.
		// 이렇게 작성해도 됨.
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("한 줄 문자열을 입력하세요.....");
		try {
			// readLine() : 보조 스트림에서 한 줄을 입력받는 메서드.
			
			String str = br.readLine();
			System.out.println("입력 받은 문자열 >>> " + str);
			
			// 입출력 개게는 닫아 주어야 한다.(나중에 생성한 순서부터 역순으로)
			br.close();
			isr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
