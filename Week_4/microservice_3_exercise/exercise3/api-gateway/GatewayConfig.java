@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("customer-service", r -> r.path("/customers/**")
                .filters(f -> f.rewritePath("/customers/(?<segment>.*", "/${segment}")
                    .requestRateLimiter(config -> config.setRateLimiter(redisRateLimiter())))
                .uri("lb://customer-service"))
            .route("billing-service", r -> r.path("/billings/**")
                .filters(f -> f.rewritePath("/billings/(?<segment>.*", "/${segment}")
                    .requestRateLimiter(config -> config.setRateLimiter(redisRateLimiter())))
                .uri("lb://billing-service"))
            .build();
    }
}
