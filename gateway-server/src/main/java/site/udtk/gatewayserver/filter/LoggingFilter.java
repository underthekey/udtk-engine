package site.udtk.gatewayserver.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoggingFilter implements GlobalFilter, Ordered {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		String requestPath = exchange.getRequest().getPath().toString();
		HttpMethod method = exchange.getRequest().getMethod();
		String queryParams = exchange.getRequest().getQueryParams().toString();

		log.info("Incoming request - Path: {}, Method: {}, Query Params: {}", requestPath, method, queryParams);

		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
			log.info("Response processed for - Path: {}, Status Code: {}", requestPath,
				exchange.getResponse().getStatusCode());
		}));
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
