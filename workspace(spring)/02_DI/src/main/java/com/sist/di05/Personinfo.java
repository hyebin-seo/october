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
			System.out.println("�� �� : " + person.getName());
			System.out.println("�� �� : " + person.getGender());
			System.out.println("�� �� : " + person.getAge());
			System.out.println("�ֹι�ȣ : " + person.getJuminNo());
		}
	}
}
