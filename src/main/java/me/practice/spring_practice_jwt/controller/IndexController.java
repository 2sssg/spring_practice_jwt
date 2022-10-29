package me.practice.spring_practice_jwt.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.practice.spring_practice_jwt.dto.user.AccountJoinReqDto;
import me.practice.spring_practice_jwt.model.Account;
import me.practice.spring_practice_jwt.services.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequiredArgsConstructor
public class IndexController {

	private final AccountService userService;

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

	@PostMapping("/create-account")
	public @ResponseBody String userCreate(AccountJoinReqDto userJoinReqDto) {
		log.info(userJoinReqDto.toString());
//		return userService.createUser(userJoinReqDto).toString();
		return "redirect:/login";
	}
}
