package com.sist.di09;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;

/*
 * DI ���� �� Java �ڵ忡�� �ֳ����̼��� �����Ͽ� �����ϴ� ���
 * 
 * - ���� �� cglib ���̺귯���� �ݵ�� �ʿ���.
 *  ==> pom.xml ���Ͽ� ���̺귯���� �߰��� �־�� ��.
 *  
 * - @Configuration, @Bean �ֳ����̼��� �����.
 * - @Configuration : Ŭ���� �տ� �����ϴ� �ֳ����̼�.
 *  ==> "�ش� Ŭ������ ������������ ���Ǵ� Ŭ�����Դϴ�."��� �˷��ִ� �ֳ����̼�
 *  
 * - @Bean : �޼ҵ� �տ� ���Ǵ� �ֳ����̼�. "�ش� �޼���� ��ü�� �����ϴµ� ���" �ȴٴ� �ǹ�.
 * 
 * - �ֳ����̼��� ����
 *  > �����̷����� ������ �˷��ִ� ����
 *  > ������ �� ���� ��ġ ���� �۾��� �����ϴ� ����.
 *  > ������ ���� ������ ó���� �ʿ��� ��� ���Ǵ� ����. 
 * */

@Configuration
public class Config {
	
	public Player player1() {
		ArrayList<String> position = new ArrayList<String>();
		position.add("4�� Ÿ��");
		position.add("1���");
		
		Player player = new Player("�߽ż�", 38, position);
		
		player.setWeight(100);
		player.setHeight(188);
		
		return player;
	}
	
	public Player player2() {
		ArrayList<String> position = new ArrayList<String>();
		position.add("9�� Ÿ��");
		position.add("����");
		
		Player player = new Player("������", 33, position);
		
		player.setWeight(110);
		player.setHeight(190);
		
		return player;
	}
}
