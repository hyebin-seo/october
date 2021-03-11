package overriding;

public abstract class Animal {
	
	abstract void sound();; //추상메서드
	
	void color() {
		System.out.println("검정색입니다.");
	}
}
