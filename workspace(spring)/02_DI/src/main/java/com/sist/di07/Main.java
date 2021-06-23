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
		System.out.println("선수 이름: "+player2.getName());
		System.out.println("선수 나이: "+player2.getAge());
		System.out.println("선수 포지션: "+player2.getPosition());
		System.out.println("선수 몸무게: "+player2.getWeight());
		System.out.println("선수 키: "+player2.getHeight());
		System.out.println("===============================");
		
		Player player3 = (Player) ctx.getBean("player3");
		System.out.println("선수 이름: "+player3.getName());
		System.out.println("선수 나이: "+player3.getAge());
		System.out.println("선수 포지션: "+player3.getPosition());
		System.out.println("선수 몸무게: "+player3.getWeight());
		System.out.println("선수 키: "+player3.getHeight());
		System.out.println("===============================");
		
		BaseballTeam team = (BaseballTeam) ctx.getBean("team");
		System.out.println(":::국가대표 야구 선수단:::");
		System.out.println("대표팀 감독 : " + team.getManager());
		System.out.println("대표팀 타격코치 : " + team.getBattingCoach());
		System.out.println("대표팀 투수코치 : " + team.getPitcherCoach());
		System.out.println("대표팀 타자 : " + team.getHitter());
		System.out.println("대표팀 투수 : " + team.getPitcher());
		ctx.close();
	}

}
