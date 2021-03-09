package classes;

public class Receipt {
	String name; //품명
	int danga;   //단가
	int ea;      //수량
	double buga = 1.1;
	
	public Receipt() {
		
	}
	
	public Receipt(String n, int d, int e) {
		name = n;
		danga = d;
		ea = e;
	}
	
	public int price() {
		return danga * ea;
	}
	
	public int gong(int total) {
		return (int) (total / buga);
	}
	
	public int bugase(int total, int gong) {
		return total - gong;
	}
	
	public int chungu(int gong, int bugase) {
		return gong + bugase;
	}

}
