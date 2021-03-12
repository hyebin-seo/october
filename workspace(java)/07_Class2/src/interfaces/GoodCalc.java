package interfaces;

public class GoodCalc implements Calculator {

	@Override
	public int add(int su1, int su2) {
		
		return su1 + su2;
	}

	@Override
	public int sub(int s1, int s2) {
		
		return s1 - s2;
	}

	@Override
	public int mul(int a1, int a2) {
		
		return a1 * a2;
	}

	@Override
	public int divide(int aa1, int aa2) {
		
		return aa1 / aa2;
	}

}
