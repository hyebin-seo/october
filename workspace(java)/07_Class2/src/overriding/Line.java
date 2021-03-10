package overriding;

public class Line extends Shape{
	@Override
	void draw() {
		System.out.println("선을 그리다.");
	}
}
