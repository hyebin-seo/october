package classes;

public class Rectangle {

	int width; //가로
	int height; //세로
	
	public Rectangle() {
		
	}
	
	public Rectangle(int w, int h) {
		width = w;
		height = h;
	}
	
	public int area() {
		return width * height;
	}
	
	public int circum() {
		return (width + height)*2;
	}
}
