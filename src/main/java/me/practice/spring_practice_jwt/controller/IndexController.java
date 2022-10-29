package me.practice.spring_practice_jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

}
