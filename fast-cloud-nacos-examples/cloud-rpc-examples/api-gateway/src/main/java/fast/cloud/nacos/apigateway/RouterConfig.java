package fast.cloud.nacos.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * COPYRIGHT © 2005-2018 CHARLESKEITH ALL RIGHTS RESERVED.
 *
 * @author Batman.qin
 * @create 2019-01-14 10:08
 */
@Configuration
public class RouterConfig {
    static final String prefix = "";

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("SERVICE-FEIGN", r ->
                        r.path(prefix + "/service-feign/**").
                                filters(f -> f.rewritePath(prefix + "service-feign/(?<remaining>.*)", "/$\\{remaining}"))
                                .uri("lb://service-feign"))
                .build();

    }

}