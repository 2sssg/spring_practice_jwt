package me.practice.spring_practice_jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {


	/**
	 * 인덱스 페이지 리턴하는 리스너
	 * @return index.html
	 */
	@GetMapping({"", "/"})
	public String index() {
		// mustache deault directory
		// src/main/resources
		// view resolver config : templates (prefix), .mustache (suffix) // 생략가능!
		return "index";
	}

	@GetMapping("/user")
	public String user() {
		return "user";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/manager")
	public String manager() {
		return "manager";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/join")
	public String join() {
		return "join";
	}

	@GetMapping("/joinProc")
	public @ResponseBody String joinProc() {
		return "회원가입 완료!";
	}

}
