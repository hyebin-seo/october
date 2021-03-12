package inheritance;

public class Point3D extends Point {

	int z;
	
	public Point3D() { super(); }
	
	public Point3D(int x, int y) {
		super(x, y);
	}
	
	public Point3D(int x, int y, int z) {
		// this.x = x;
		// this.y = y;
		this(x, y);
		this.z = z;
	}
	
	void output() {
		System.out.println("x 좌표 : " + x);
		System.out.println("y 좌표 : " + y);
		System.out.println("z 좌표 : " + z);
	}
	
}
