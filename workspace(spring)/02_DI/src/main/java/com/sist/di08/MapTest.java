package com.sist.di08;

import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class MapTest {
	private Map<Integer, String> map;
	
	public void output() {
		// KeySet(); Map�� �ִ� Ű�� ���� �� �������� �޼���
		Set<Integer> set = map.keySet();
		
		for(Integer k : set) {
			System.out.println(map.get(k));
		}
	}
}
