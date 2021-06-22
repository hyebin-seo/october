package com.test.nonspring02;

public class MyCalculater {
	private int firstNum;
	private int secondNum;
	private Calculator cal;
	
	public MyCalculater() {
	
	}
	
	public MyCalculater(int first, int second, Calculator cal) {
		this.firstNum = first;
		this.secondNum = second;
		this.cal = cal;
	}
	
	public int getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public int getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

	public Calculator getCal() {
		return cal;
	}

	public void setCal(Calculator cal) {
		this.cal = cal;
	}

	public void result() {
		int value = cal.sum(firstNum, secondNum);
		System.out.println("result >>>" + value);
	}
	
}
