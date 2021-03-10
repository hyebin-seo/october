package overriding;

public class Circle extends Shape{
	@Override
	void draw() {
		System.out.println("원을 그리다.");
	}
}
