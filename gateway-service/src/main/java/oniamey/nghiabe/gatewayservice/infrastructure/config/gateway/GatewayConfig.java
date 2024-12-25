package oniamey.nghiabe.gatewayservice.infrastructure.config.gateway;

import oniamey.nghiabe.gatewayservice.infrastructure.security.AuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix
public class GatewayConfig {

    private final AuthenticationFilter filter;

    public GatewayConfig(AuthenticationFilter filter) {
        this.filter = filter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("common-service", r -> r.path("/common-service/**")
                        .filters(f -> f.filter(filter).stripPrefix(1))
                        .uri("lb://common-service"))

                .route("auth-service", r -> r.path("/auth-service/**")
                        .filters(f -> f.filter(filter).stripPrefix(1))
                        .uri("lb://auth-service"))
                .build();
    }

}