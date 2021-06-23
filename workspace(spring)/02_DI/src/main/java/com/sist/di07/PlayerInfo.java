package com.sist.di07;

import lombok.Data;

@Data
public class PlayerInfo {
	private Player player;
	
	public void getPlayerInfo() {
		System.out.println("선수 이름: "+player.getName());
		System.out.println("선수 나이: "+player.getAge());
		System.out.println("선수 포지션: "+player.getPosition());
		System.out.println("선수 몸무게: "+player.getWeight());
		System.out.println("선수 키: "+player.getHeight());
	}
}
