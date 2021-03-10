package overriding;

public class Cat extends Animal{
	@Override
	void sound() {
		System.out.println("냥냥냥");
	}
}
