package me.practice.spring_practice_jwt.oauth.provider;

import java.util.Map;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FacebookAccountInfo implements OAuth2AccountInfo{

	private Map<String, Object> attributes;

	@Override
	public String getProviderId() {
		return (String) this.attributes.get("id");
	}

	@Override
	public String getProvider() {
		return "facebook";
	}

	@Override
	public String getEmail() {
		return (String) this.attributes.get("email");
	}

	@Override
	public String getName() {
		return (String) this.attributes.get("name");
	}
}
