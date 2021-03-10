package inheritance;

import java.util.Scanner;

class Volume {
	
	// 멤버변수
	int vol = 1;
	
	public void setVolume(int vol) {
		this.vol = vol;
	}
	
	public int getVolume() {
		return vol;
	}
	
	// 볼륨을  올리는 메서드
	void volume_up() {
		vol++;
		if(vol > 15) {
			vol = 15;
		}
	}
	
	// 볼륨을 내리는 메서드
	void volume_down() {
		vol--;
		if(vol < 1) {
			vol = 1;
		}
	}
} //Volume 클래스 end

class TV extends Volume {} //TV 자식 클래스

class Computer extends Volume { } //Computer 자식 클래스

class Radio extends Volume {} //Radio 자식 클래스

public class Ex05_Remote {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		TV tv = new TV();
		Computer computer = new Computer();
		Radio radio = new Radio();
		
		int menu, volume;
		
		while(true) {  // 무한반복
			System.out.print("1.TV / 2.Radio / 3.Computer / 4.Exit : ");
			menu = sc.nextInt();
			
			if(menu == 4) {
				break;
			}
			
			System.out.println("1.볼륨 Up / 2.볼륨 Down : ");
			volume = sc.nextInt();
			
			switch(menu) {
				case 1 : //TV를 선택한 경우
					if(volume == 1) { // 볼륨 Up 선택했는지 여부
						tv.volume_up();
					} else if(volume == 2) {
						tv.volume_down();
					}
					break;
				case 2 : //Radio를 선택한 경우
					if(volume == 1) { // 볼륨 Up 선택했는지 여부
						radio.volume_up();
					} else if(volume == 2) {
						radio.volume_down();
					}
					break;
				case 3 : //Computer를 선택한 경우
					if(volume == 1) { // 볼륨 Up 선택했는지 여부
						computer.volume_up();
					} else if(volume == 2) {
						computer.volume_down();
					}
					break;
			} // switch~case문 end
			
			System.out.println();
			
			System.out.println(":::::::::::::::::::::::::::::");
			
			System.out.println("TV : "+tv.getVolume()+
							   "/ Radio : "+radio.getVolume()+
							   "/ Computer : "+computer.getVolume());

		} // while 반복문 end
		
		System.out.println();
		System.out.println("수고 많이 하셨습니다!!!");
		
		sc.close();

	}

}
