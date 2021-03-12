package abstracts;

public class IPhone extends SmartPhone {

	@Override
	void spec() {
		company = "애플"; name = "IPhone 11"; color = "화이트";
		size = "15cm"; weight = "200g"; price = "150만원";
		
		System.out.println
		 (company+" / "+name+" / "+color+" / "+size+" / "+weight+" / "+price);
		
	}

}
