package com.sist.di07;

import lombok.Data;

@Data
public class PlayerInfo {
	private Player player;
	
	public void getPlayerInfo() {
		System.out.println("���� �̸�: "+player.getName());
		System.out.println("���� ����: "+player.getAge());
		System.out.println("���� ������: "+player.getPosition());
		System.out.println("���� ������: "+player.getWeight());
		System.out.println("���� Ű: "+player.getHeight());
	}
}
