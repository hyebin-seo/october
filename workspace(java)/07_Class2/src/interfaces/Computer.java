package interfaces;

public class Computer implements RemoteControl {

	int volume;
	
	
	@Override
	public void turnOn() {
		System.out.println("Computer 전원을 켭니다.");	
	}

	@Override
	public void turnOff() {
		System.out.println("Computer 전원을 끕니다.");
		
	}

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.max_volume) {
			this.volume = RemoteControl.max_volume;
		}else if(volume < RemoteControl.min_volume) {
			this.volume = RemoteControl.min_volume;
		}else {
			this.volume = volume;
		}
		
		System.out.println("현재 Computer 볼륨 >>> " + this.volume);
	}
}
