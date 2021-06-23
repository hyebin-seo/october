package com.sist.di02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:exam.xml");
		
		ExamDAO dao = (ExamDAO) ctx.getBean("daoImpl");
	}

}
