package overriding;

public class Ex01_Animal {

	public static void main(String[] args) {
		
		Dog dog = new Dog();
		dog.sound();
		
		Cat cat = new Cat();
		cat.sound();
		
		Tiger tiger = new Tiger();
		tiger.sound();

	}

}
