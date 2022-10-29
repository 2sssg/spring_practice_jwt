package me.practice.spring_practice_jwt.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@ToString
public class AccountJoinReqDto {

	private String username;

	private String password;

	private String email;

	public AccountJoinReqDto encodePassword(PasswordEncoder passwordEncoder) {
		this.password = passwordEncoder.encode(this.password);
		return this;
	}
}
