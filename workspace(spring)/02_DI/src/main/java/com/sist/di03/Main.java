package com.sist.di03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:mydao.xml");
		
		ServiceImpl serviceImpl = (ServiceImpl) ctx.getBean("service");
		serviceImpl.biz();
		
		ctx.close();
	}
}
