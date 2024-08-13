package site.udtk.config.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.config.server.EnableConfigServer;

import site.udtk.config.configserver.config.UserConfig;

@SpringBootApplication
@EnableConfigServer
@EnableConfigurationProperties(UserConfig.class)
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
