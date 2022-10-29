package me.practice.spring_practice_jwt.config;

import lombok.RequiredArgsConstructor;
import me.practice.spring_practice_jwt.oauth.OAuth2AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

	private final OAuth2AccountService oAuth2AccountService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.csrf().disable()
				.authorizeRequests()
					.antMatchers("/user/**").authenticated()
					.antMatchers("/manager/**")
						.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
					.antMatchers("/admin/**")
						.hasRole("ADMIN")
					.anyRequest()
						.permitAll();

		httpSecurity
				.formLogin().loginPage("/login-form")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/");

		httpSecurity
				.oauth2Login()
				.loginPage("/login-form")
				.userInfoEndpoint()
				.userService(oAuth2AccountService);

		return httpSecurity.build();
	}

}
