package me.practice.spring_practice_jwt.common;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "my-app")
@Getter @Setter
public class AppProperties {

	@NotEmpty
	private String adminUsername;
	@NotEmpty
	private String managerUsername;
	@NotEmpty
	private String userUsername;
	@NotEmpty
	private String password;
	@NotEmpty
	private String email;
}
