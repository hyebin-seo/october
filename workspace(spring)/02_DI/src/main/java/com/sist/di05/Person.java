package com.sist.di05;

import lombok.Data;

@Data
public class Person {
	private String name;
	private String gender;
	private int age;
	private String juminNo;
	
	public Person() {
	}
	
	public Person(String name, String gender, int age, String juminNo) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.juminNo = juminNo;
	}
}
