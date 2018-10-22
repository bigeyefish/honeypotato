package com.honeypotato.gateway.routes

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.filters
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Configuration

@Configuration
open class AdditionalRoutes {

    fun additionalRouteLocator(builder: RouteLocatorBuilder): RouteLocator = builder.routes {
        route(id = "text-kotlin") {
            path("/images/png")
            filters {
                addResponseHeader("X=TestHeader", "foobar")
            }
            uri("http://httpbin.org:80")
        }
    }
}