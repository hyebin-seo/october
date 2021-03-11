package abstracts;

public class Galaxy extends SmartPhone{

	@Override
	void spec() {
		company = "삼성";
		name = "Galaxy S21";
		color = "화이트";
		size = "20cm";
		weight = "350g";
		price = "170만원";
		
		System.out.println
		(company+" / "+name+" / "+color+" / "+size+" / "+weight+" / "+price);
		
	}

}
