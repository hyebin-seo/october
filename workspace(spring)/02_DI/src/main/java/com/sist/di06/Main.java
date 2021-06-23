package com.sist.di06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:car.xml");
		Car car = (Car) ctx.getBean("car");
		car.drive();
		
		ctx.close();
	}

}
