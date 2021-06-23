package com.sist.di07;

import lombok.Data;

@Data
public class BaseballTeam {
	private String manager;
	private String battingCoach;
	private String pitcherCoach;
	private String hitter;
	private String pitcher;
	
	public BaseballTeam() {
	}
	
	public BaseballTeam(String manager,
			String battingCoach, String pitcherCoach) {
		this.manager = manager;
		this.battingCoach = battingCoach;
		this.pitcherCoach = pitcherCoach;
	}
}
