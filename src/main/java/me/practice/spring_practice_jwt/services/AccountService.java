package me.practice.spring_practice_jwt.services;

import lombok.RequiredArgsConstructor;
import me.practice.spring_practice_jwt.dto.user.AccountJoinReqDto;
import me.practice.spring_practice_jwt.enums.Role;
import me.practice.spring_practice_jwt.model.Account;
import me.practice.spring_practice_jwt.repositories.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

	private final AccountRepository userRepository;

	private final ModelMapper modelMapper;

	public Account createUser(AccountJoinReqDto userJoinReqDto) {
		Account user = modelMapper.map(userJoinReqDto, Account.class);

		user.setRole(Role.USER);

		return userRepository.save(user);
	}



}
