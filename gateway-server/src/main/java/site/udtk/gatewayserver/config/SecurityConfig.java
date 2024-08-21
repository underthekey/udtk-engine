package site.udtk.gatewayserver.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableConfigurationProperties(UserConfig.class)
@RequiredArgsConstructor
public class SecurityConfig {

	private final UserConfig userConfig;

	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		http
			.csrf(ServerHttpSecurity.CsrfSpec::disable)
			.authorizeExchange(exchanges -> exchanges.anyExchange().authenticated())
			.httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	public ReactiveUserDetailsService userDetailsService() {
		UserDetails user = User.builder()
			.username(userConfig.getUsername())
			.password(bcryptPasswordEncoder().encode(userConfig.getPassword()))
			.roles(userConfig.getRole())
			.build();
		return new MapReactiveUserDetailsService(user);
	}
}
