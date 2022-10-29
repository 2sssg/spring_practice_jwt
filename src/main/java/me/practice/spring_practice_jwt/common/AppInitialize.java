package me.practice.spring_practice_jwt.common;


import me.practice.spring_practice_jwt.enums.Role;
import me.practice.spring_practice_jwt.model.Account;
import me.practice.spring_practice_jwt.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppInitialize {

	@Bean
	public ApplicationRunner applicationRunner() {
		return new ApplicationRunner() {
			@Autowired AccountService accountService;
			@Autowired AppProperties appProperties;
			@Override
			public void run(ApplicationArguments args) throws Exception {
				Account admin = Account.builder()
						.username(appProperties.getAdminUsername())
						.password(appProperties.getPassword())
						.email(appProperties.getEmail())
						.role(Role.ADMIN)
						.build();
				Account manager = Account.builder()
						.username(appProperties.getManagerUsername())
						.password(appProperties.getPassword())
						.email(appProperties.getEmail())
						.role(Role.MANAGER)
						.build();
				Account user = Account.builder()
						.username(appProperties.getUserUsername())
						.password(appProperties.getPassword())
						.email(appProperties.getEmail())
						.build();
				accountService.createAccount(admin);
				accountService.createAccount(manager);
				accountService.createAccount(user);
			}
		};
	}

}
