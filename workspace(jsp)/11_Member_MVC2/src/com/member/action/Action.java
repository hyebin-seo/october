package com.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	// 추상메서드
	String execute(HttpServletRequest req, HttpServletResponse res);
}
