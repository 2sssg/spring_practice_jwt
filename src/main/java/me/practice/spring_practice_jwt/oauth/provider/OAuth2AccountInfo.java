package me.practice.spring_practice_jwt.oauth.provider;

public interface OAuth2AccountInfo {
	String getProviderId();
	String getProvider();
	String getEmail();
	String getName();
}
