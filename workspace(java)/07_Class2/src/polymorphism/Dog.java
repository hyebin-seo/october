package polymorphism;

public class Dog implements Animal{
	
	@Override
	public void sound() {
		System.out.println("멍멍멍~~~");
		
	}
	
	void output() {
		System.out.println("Dog Class method");
	}

}
