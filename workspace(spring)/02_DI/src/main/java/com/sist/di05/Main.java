package com.sist.di05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:person.xml");
		
		Personinfo info = (Personinfo) ctx.getBean("info");
		
		info.getPersonInfo();
		
		ctx.close();
	}

}
