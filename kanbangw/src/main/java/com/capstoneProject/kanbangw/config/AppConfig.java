package com.capstoneProject.kanbangw.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RouteLocator getRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route( p->p
                        .path("/employee-app/v1/**")
                        .uri("http://localhost:8888/*") )
//                .route( p->p
//                        .path("/userproduct/v1/**")
//                        .uri("http://localhost:9999/*"))
                .build();

    }
}
