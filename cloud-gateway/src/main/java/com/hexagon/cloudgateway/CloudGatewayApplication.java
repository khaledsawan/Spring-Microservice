package com.hexagon.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
	}
	
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("customer-service", r -> r.path("/customer/**")
                .filters(f -> f.circuitBreaker(c -> c.setName("customerServiceCircuitBreaker")
                        .setFallbackUri("forward:/customerFallback")
                        .addStatusCode("INTERNAL_SERVER_ERROR")))
                .uri("lb://CUSTOMER-SERVICE"))

            .route("company-service", r -> r.path("/company/**")
                .filters(f -> f.circuitBreaker(c -> c.setName("companyServiceCircuitBreaker")
                        .setFallbackUri("forward:/companyFallback")
                        .addStatusCode("INTERNAL_SERVER_ERROR")))
                .uri("lb://COMPANY-SERVICE"))

            .route("transaction-service", r -> r.path("/transaction/**")
                .filters(f -> f.circuitBreaker(c -> c.setName("transactionServiceCircuitBreaker")
                        .setFallbackUri("forward:/transactionFallback")
                        .addStatusCode("INTERNAL_SERVER_ERROR")))
                .uri("lb://TRANSACTION-SERVICE"))

            .route("sale-service", r -> r.path("/sale/**")
                .filters(f -> f.circuitBreaker(c -> c.setName("saleServiceCircuitBreaker")
                        .setFallbackUri("forward:/saleFallback")
                        .addStatusCode("INTERNAL_SERVER_ERROR")))
                .uri("lb://SALE-SERVICE"))

            .route("listing-service", r -> r.path("/listing/**")
                .filters(f -> f.circuitBreaker(c -> c.setName("listingServiceCircuitBreaker")
                        .setFallbackUri("forward:/listingFallback")
                        .addStatusCode("INTERNAL_SERVER_ERROR")))
                .uri("lb://LISTING-SERVICE"))
            .build();
    }

}
