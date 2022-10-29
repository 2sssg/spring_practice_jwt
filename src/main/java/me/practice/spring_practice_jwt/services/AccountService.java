package me.practice.spring_practice_jwt.services;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import me.practice.spring_practice_jwt.dto.user.AccountJoinReqDto;
import me.practice.spring_practice_jwt.enums.Role;
import me.practice.spring_practice_jwt.model.Account;
import me.practice.spring_practice_jwt.repositories.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

	private final AccountRepository userRepository;

	private final ModelMapper modelMapper;

	private final PasswordEncoder passwordEncoder;


	public Account createAccount(AccountJoinReqDto userJoinReqDto) {
		Account optionalAccount = getAccount(userJoinReqDto.getUsername());

		if (optionalAccount != null)
			return optionalAccount;

		Account user = modelMapper.map(userJoinReqDto.encodePassword(passwordEncoder), Account.class);
		user.setRole(Role.USER);
		return userRepository.save(user);
	}

	public Account createAccount(Account account) {
		Account optionalAccount = getAccount(account.getUsername());

		if (optionalAccount != null)
			return optionalAccount;

		if (account.getRole() == null)
			account.setRole(Role.USER);

		account.setPassword(passwordEncoder.encode(account.getPassword()));
		return userRepository.save(account);
	}

	private Account getAccount(String username) {
		Optional<Account> optionalAccount = userRepository.findByUsername(username);
		return optionalAccount.orElse(null);
	}

}
