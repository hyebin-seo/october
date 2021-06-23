package com.sist.di07;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String path1 = "classpath:baseball.xml";
		String path2 = "classpath:baseball2.xml";
		
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext(path1, path2);
		
		PlayerInfo player = (PlayerInfo) ctx.getBean("info");
		player.getPlayerInfo();
		
		System.out.println("===============================");
		
		Player player2 = (Player) ctx.getBean("player2");
		System.out.println("���� �̸�: "+player2.getName());
		System.out.println("���� ����: "+player2.getAge());
		System.out.println("���� ������: "+player2.getPosition());
		System.out.println("���� ������: "+player2.getWeight());
		System.out.println("���� Ű: "+player2.getHeight());
		System.out.println("===============================");
		
		Player player3 = (Player) ctx.getBean("player3");
		System.out.println("���� �̸�: "+player3.getName());
		System.out.println("���� ����: "+player3.getAge());
		System.out.println("���� ������: "+player3.getPosition());
		System.out.println("���� ������: "+player3.getWeight());
		System.out.println("���� Ű: "+player3.getHeight());
		System.out.println("===============================");
		
		BaseballTeam team = (BaseballTeam) ctx.getBean("team");
		System.out.println(":::������ǥ �߱� ������:::");
		System.out.println("��ǥ�� ���� : " + team.getManager());
		System.out.println("��ǥ�� Ÿ����ġ : " + team.getBattingCoach());
		System.out.println("��ǥ�� ������ġ : " + team.getPitcherCoach());
		System.out.println("��ǥ�� Ÿ�� : " + team.getHitter());
		System.out.println("��ǥ�� ���� : " + team.getPitcher());
		ctx.close();
	}

}
