package exam2;

public class Rectangle implements Shape {

	// 멤버변수
	int width;
	int height;
	
	
	public Rectangle() {  }
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	
	@Override
	public double findArea() {
		
		return width * height;
		
	}

}
