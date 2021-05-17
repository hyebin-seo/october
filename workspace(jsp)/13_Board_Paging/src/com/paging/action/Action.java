package com.paging.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

	// 추상 메서드
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException;
}
