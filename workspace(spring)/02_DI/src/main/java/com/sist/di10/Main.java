package com.sist.di10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:baseball3.xml");
		
		Player player1 = (Player) ctx.getBean("player1");
		System.out.println("���� �̸�: "+player1.getName());
		System.out.println("���� ����: "+player1.getAge());
		System.out.println("���� ������: "+player1.getPosition());
		System.out.println("���� ������: "+player1.getWeight());
		System.out.println("���� Ű: "+player1.getHeight());
		System.out.println("===============================");
		
		Player player2 = (Player) ctx.getBean("player2");
		System.out.println("���� �̸�: "+player2.getName());
		System.out.println("���� ����: "+player2.getAge());
		System.out.println("���� ������: "+player2.getPosition());
		System.out.println("���� ������: "+player2.getWeight());
		System.out.println("���� Ű: "+player2.getHeight());
		System.out.println("===============================");

		ctx.close();
	}

}
