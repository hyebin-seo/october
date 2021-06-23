package com.sist.di10;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;

/*
 * DI 설정 시 Java 코드에서 애노테이션을 설정하여 주입하는 방법
 * 
 * - 설정 시 cglib 라이브러리가 반드시 필요함.
 *  ==> pom.xml 파일에 라이브러리를 추가해 주어야 함.
 *  
 * - @Configuration, @Bean 애노테이션을 사용함.
 * - @Configuration : 클래스 앞에 선언하는 애노테이션.
 *  ==> "해당 클래스는 스프링설정에 사용되는 클래스입니다."라고 알려주는 애노테이션
 *  
 * - @Bean : 메소드 앞에 사용되는 애노테이션. "해당 메서드는 객체를 생성하는데 사용" 된다는 의미.
 * 
 * - 애노테이션의 역할
 *  > 컴파이러에게 정보를 알려주는 역할
 *  > 컴파일 할 때와 설치 시의 작업을 지정하는 역할.
 *  > 실행할 때에 별도의 처리가 필요한 경우 사용되는 역할. 
 * */

@Configuration
public class Config {
	
	public Player player1() {
		ArrayList<String> position = new ArrayList<String>();
		position.add("4번 타자");
		position.add("1루수");
		
		Player player = new Player("추신수", 38, position);
		
		player.setWeight(100);
		player.setHeight(188);
		
		return player;
	}
	
	public Player player2() {
		ArrayList<String> position = new ArrayList<String>();
		position.add("9번 타자");
		position.add("투수");
		
		Player player = new Player("류현진", 33, position);
		
		player.setWeight(110);
		player.setHeight(190);
		
		return player;
	}
}
