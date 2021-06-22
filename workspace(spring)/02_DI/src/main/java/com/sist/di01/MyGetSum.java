package com.sist.di01;

public class MyGetSum {

	private int num1;
	private int num2;
	private GetSum getSum;
	
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public GetSum getGetSum() {
		return getSum;
	}
	public void setGetSum(GetSum getSum) {
		this.getSum = getSum;
	}
	
	// ÇÙ½É ±â´É
	public void sum() {
		this.getSum.hap(num1,num2);
	}
}
