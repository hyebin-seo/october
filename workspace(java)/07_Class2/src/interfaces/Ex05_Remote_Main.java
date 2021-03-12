package interfaces;

public class Ex05_Remote_Main {

	public static void main(String[] args) {
		
		Audio audio = new Audio();
		Computer computer = new Computer();
		TV tv = new TV();
		
		// Audio
		audio.turnOn();
		audio.setVolume(7);
		audio.turnOff();
		System.out.println();
		
		// Computer
		computer.turnOn();
		computer.setVolume(13);
		computer.turnOff();
		System.out.println();
		
		// TV
		tv.turnOn();
		tv.setVolume(0);
		tv.turnOff();

	}

}
