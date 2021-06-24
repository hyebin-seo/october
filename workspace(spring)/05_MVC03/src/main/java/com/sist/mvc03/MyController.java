package com.sist.mvc03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/input")
	public String input() {
		
		return "personInput";
	}
	
	
	@RequestMapping("/insert_ok")
	public String inputOk(Person person, Model model) {
		
		// String name = request.getParameter("name").trim();
		// String id = request.getParameter("id").trim();
		// String pwd = request.getParameter("pwd").trim();
		// String age = request.getParameter("age").trim();
		// String addr = request.getParameter("addr").trim();
		// String email = request.getParameter("email").trim();
		
		// model.addAttribute("userName", name);
		// model.addAttribute("userId", id);
		// model.addAttribute("userPwd", pwd);
		// model.addAttribute("userAge", age);
		// model.addAttribute("userAddr", addr);
		// model.addAttribute("userEmail", email);
		
		model.addAttribute("dto", person);
		
		return "userInfo";
	
	}
}
