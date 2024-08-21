package site.udtk.gatewayserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@ConfigurationProperties(prefix = "user-details")
@RequiredArgsConstructor
public class UserConfig {
	private final String username;
	private final String password;
	private final String role;
}
