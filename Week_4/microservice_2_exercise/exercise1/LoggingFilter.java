@Component
public class LoggingFilter implements GlobalFilter {
@Override
public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
System.out.println("Request: " + exchange.getRequest().getURI());
return chain.filter(exchange);
}
}
