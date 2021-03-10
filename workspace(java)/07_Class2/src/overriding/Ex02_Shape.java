package overriding;

public class Ex02_Shape {

	public static void main(String[] args) {
		
		Line line = new Line();
		Rectangle rectangle = new Rectangle();
		Circle circle = new Circle();
		
		line.draw();
		rectangle.draw();
		circle.draw();

	}

}
