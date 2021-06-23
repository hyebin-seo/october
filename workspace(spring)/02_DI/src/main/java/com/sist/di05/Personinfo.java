package com.sist.di05;

public class Personinfo {
	private Person person;
	
	public Personinfo() {
	}
	
	public Personinfo(Person person) {
		this.person = person;
	}
	
	public void getPersonInfo() {
		if(person != null) {
			System.out.println("이 름 : " + person.getName());
			System.out.println("성 별 : " + person.getGender());
			System.out.println("나 이 : " + person.getAge());
			System.out.println("주민번호 : " + person.getJuminNo());
		}
	}
}
