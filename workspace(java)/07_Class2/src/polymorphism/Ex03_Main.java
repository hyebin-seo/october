package polymorphism;

class A {}

class B extends A {}

class C extends A {}

class D extends B {}

class E extends C {}

public class Ex03_Main {

	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		
		B b1 = d;
		C c1 = e;
		
		//e는 C를 상속 받았고, d는 b를 상속 받았기 때문에 다형성으로 객체 생성할 수 없다.
		//B b2 = e;
		//C c2 = d;
		
		// instanceof : 두 개의 객체가 같은 지 물어보는 연산자
		if(d instanceof B) {
			System.out.println("true");
		}

	}

}
