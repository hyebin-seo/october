package util;

import java.util.Calendar;

/*
 * 3. Calendar 클래스
 *    - 날짜 / 시간과 관련된 정보를 제공해 주는 클래스.
 *    - Calendar 클래스는 추상클래스임.
 *    - 추상클래스로 작성된 이유 : 날짜와 시간을 계산하는 방법이 지역, 문화, 나라마다
 *                         다르기 때문임.
 *    - Calendar 클래스에는 날짜와 시간을 계산하는데 꼭 필요한 메서드나 상수로
 *      구성이 되어 있음.
 *    - 추상클래스이지만 getInstance() 메서드를 이용하여 시스템의 날짜와 시간
 *      정보를 표현할 수 있음.
 *    - getInstance() : 싱글턴 방식. 하나의 인스턴스만을 가지고 공유해서
 *                      사용할 때 쓰는 방식.
 */

public class Ex03 {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
		
		// 날짜와 관련된 정보를 확인하는 방법
		int year = cal.get(Calendar.YEAR);         // 현재 년도
		int month = cal.get(Calendar.MONTH) + 1;   // 현재 월
		int day = cal.get(Calendar.DAY_OF_MONTH);  // 현재 일
		int week = cal.get(Calendar.WEEK_OF_YEAR); // 1년 52 주중 몇번째 주 확인
		
		
		System.out.println("현재 년도 >>> " + year + "년");
		System.out.println("현재 월 >>> " + month + "월");
		System.out.println("현재 일 >>> " + day + "일");
		System.out.println("현재 주 >>> " + week + "주");
		System.out.println();
		
		
		// 시간과 관련된 정보를 확인하는 방법.
		// 1. 12시간제를 이용하는 방법 - 오전(0), 오후(1)
		//    형식) Calendar.AM_PM
		int am_pm = cal.get(Calendar.AM_PM);
		int hour = cal.get(Calendar.HOUR);      // 몇 시
		int minute = cal.get(Calendar.MINUTE);  // 몇 분
		int second = cal.get(Calendar.SECOND);  // 몇 초
		
		System.out.println(am_pm);
		
		if(am_pm == 0) {  // 오전인 경우
			System.out.println("현재 시간은 AM(오전) "+hour+"시 "+
					minute+"분 "+second+"초 입니다.");
		}else {
			System.out.println("현재 시간은 PM(오후) "+hour+"시 "+
					minute+"분 "+second+"초 입니다.");
		}
		System.out.println();
		
		
		// 2. 24시간제를 이용하는 방법
		//    형식) Calendar.HOUR_OF_DAY
		int hours = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println("현재 시간은 "+hours+"시 "+minute+"분 "+
					second+"초 입니다.");
		

	}

}
