package me.practice.spring_practice_jwt.auth;

import lombok.RequiredArgsConstructor;
import me.practice.spring_practice_jwt.model.Account;
import me.practice.spring_practice_jwt.repositories.AccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountDetailsService implements UserDetailsService {

	private final AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException(username)
		);
		System.out.println(account);
		return new AccountDetails(account);
	}
}
