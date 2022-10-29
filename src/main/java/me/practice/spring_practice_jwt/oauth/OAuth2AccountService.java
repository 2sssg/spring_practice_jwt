package me.practice.spring_practice_jwt.oauth;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import me.practice.spring_practice_jwt.auth.AccountDetails;
import me.practice.spring_practice_jwt.enums.Role;
import me.practice.spring_practice_jwt.model.Account;
import me.practice.spring_practice_jwt.oauth.provider.FacebookAccountInfo;
import me.practice.spring_practice_jwt.oauth.provider.GoogleAccountInfo;
import me.practice.spring_practice_jwt.oauth.provider.NaverAccountInfo;
import me.practice.spring_practice_jwt.oauth.provider.OAuth2AccountInfo;
import me.practice.spring_practice_jwt.services.AccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuth2AccountService extends DefaultOAuth2UserService {

	private final PasswordEncoder passwordEncoder;

	private final AccountService accountService;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

		OAuth2User oAuth2User = super.loadUser(userRequest);

		String provider = userRequest.getClientRegistration().getRegistrationId(); //google

		OAuth2AccountInfo oAuth2AccountInfo = null;
		if (provider.equals("google")) {
			oAuth2AccountInfo = new GoogleAccountInfo(oAuth2User.getAttributes());
		} else if (provider.equals("facebook")) {
			oAuth2AccountInfo = new FacebookAccountInfo(oAuth2User.getAttributes());
		} else if (provider.equals("naver")) {
			oAuth2AccountInfo = new NaverAccountInfo((Map)oAuth2User.getAttributes().get("response"));
		} else {
			System.out.println("제공하지 않는 로그인 방식 입니다.");
			throw new OAuth2AuthenticationException("제공하지 않는 로그인 방식");
		}

		String providerId = oAuth2AccountInfo.getProviderId();
		String username = provider + "_" + providerId;
		String email = oAuth2AccountInfo.getEmail();
		String password = this.passwordEncoder.encode("구글로그인비밀번호");
		Role role = Role.USER;

		Account oauthAccount = Account.builder()
				.username(username)
				.password(password)
				.email(email)
				.role(role)
				.provider(provider)
				.providerId(providerId)
				.build();

		Account savedAccount= accountService.createAccount(oauthAccount);
		System.out.println(oauthAccount);
		return new AccountDetails(savedAccount, oAuth2User.getAttributes());
	}
}
