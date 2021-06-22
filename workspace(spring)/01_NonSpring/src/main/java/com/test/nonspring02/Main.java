package com.test.nonspring02;

public class Main {

	public static void main(String[] args) {
		MyCalculater cal;
		cal = new MyCalculater(10, 5, new CalSum());
		cal.result();
	}

}
