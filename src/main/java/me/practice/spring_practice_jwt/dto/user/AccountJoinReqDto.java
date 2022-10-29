package me.practice.spring_practice_jwt.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@ToString
public class AccountJoinReqDto {

	private String username;

	private String password;

	private String email;

}
