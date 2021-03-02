package sist;

public class heart_jwerly {

	public static void main(String[] args) {
		int MAX_NUMBER = 5;
		
		for(int i=0; i<MAX_NUMBER; i++) {
			
			int count = 0;
			for(int j=MAX_NUMBER-i;j>0;j--) {
				System.out.print(" ");
				count++;
			}
			for(int k=1; k<=(MAX_NUMBER*4)-count*2; k++) {
				System.out.print("*");
			}

			System.out.println();	
		}
		
		for(int i=0; i<MAX_NUMBER*2; i++) {
			int count=0;
			for(int j=1;j<=i;j++) {
				System.out.print(" ");
				count++;
			}
			for(int k=0; k<(MAX_NUMBER*4)-(count*2); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		

	}

}
