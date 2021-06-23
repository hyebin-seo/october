package com.sist.di04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:exam1.xml");
		
		Exam exam = (Exam)ctx.getBean("exam1");
		exam.output();
		
		ctx.close();
	}

}
