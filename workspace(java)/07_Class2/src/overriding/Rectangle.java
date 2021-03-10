package overriding;

public class Rectangle extends Shape{
	@Override
	void draw() {
		System.out.println("사각형을 그리다.");
	}
}
