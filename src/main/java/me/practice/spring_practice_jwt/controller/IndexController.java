package me.practice.spring_practice_jwt.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.practice.spring_practice_jwt.dto.user.AccountJoinReqDto;
import me.practice.spring_practice_jwt.model.Account;
import me.practice.spring_practice_jwt.services.AccountService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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

	@GetMapping("/login-form")
	public String loginForm() {
		return "login-form";
	}

	@GetMapping("/join")
	public String join() {
		return "join";
	}

	@PostMapping("/create-account")
	public String userCreate(AccountJoinReqDto userJoinReqDto) {
		log.info(userJoinReqDto.toString());
		userService.createAccount(userJoinReqDto);
		return "redirect:/login-form";
	}

	@GetMapping("/info")
	@Secured("ROLE_ADMIN")
	public @ResponseBody String info() {
		return "개인정보";
	}

	@GetMapping("/data")
	@PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
	public @ResponseBody String data() {
		return "데이터 정보";
	}

}
