package exam2;

public class Circle implements Shape {

	int radius;     // 반지름 변수
	
	public Circle() {  }
	
	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public double findArea() {
		
		return 3.14 * radius * radius;
		
	}
	
	
	
}
