package com.sist.di04;

import lombok.Data;

@Data
public class Exam {
	private String msg;
	public Exam() {}
	public Exam(String msg) {
		this.msg = msg;
	}
	
	//�����Ͻ� ����
	public void output() {
		System.out.println("�޼���>>>"+msg);
	}
}
