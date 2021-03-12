package accessTwo;

import accessOne.Super;

public class Sub extends Super{

	public static void main(String[] args) {
		
		Sub sub = new Sub();
		
		// 해당 클래스에서만 접근이 가능. - private
		// System.out.println("num1 >>> " + sub.num1);
		
		// 해당 패키지 내에서만 접근이 가능. - default
		// 상속 관계에 있는 멤버라도 접근이 불가능.
		// System.out.println("num2 >>> " + sub.num2);
		
		// 패키지가 다르더라도 상속관계에 있으면 접근이 가능. - protected
		System.out.println("num3 >>> " + sub.num3);
		
		// 모든 클래스에서 접근이 가능. - public
		System.out.println("num4 >>> " + sub.num4);
	}

}
