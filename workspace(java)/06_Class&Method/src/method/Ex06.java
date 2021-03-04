package method;

/*
 * 2. call by reference
 */

public class Ex06 {
	
	public static void change(int[] array) {
		System.out.println(array);
		
		array[0] = 100;
		array[1] = 200;
		array[2] = 300;
	}
	

	public static void main(String[] args) {
		
		int[] arr = new int[3];
		arr[0] = 10; arr[1] = 20; arr[2] = 30;
		
		System.out.println("change() 메서드 호출 전.....");
		System.out.println(arr);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println("arr["+i+"] >>> " + arr[i]);
		}
		
		System.out.println();
		
		change(arr);
		
		System.out.println("change() 메서드 호출 후.....");
		
		for(int i=0; i<arr.length; i++) {
			System.out.println("arr["+i+"] >>> " + arr[i]);
		}

	}

}
