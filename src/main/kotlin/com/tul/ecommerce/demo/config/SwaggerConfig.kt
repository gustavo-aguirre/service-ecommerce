package com.tul.ecommerce.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*


@Configuration
@EnableSwagger2
class SwaggerConfig {



    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.tul.ecommerce.demo.controller"))
        .build()
        .apiInfo(apiInfo());


    fun apiInfo(): ApiInfo? {
        return ApiInfo(
            "Ecommerce",
            "Servicio para administrar un carrito de compras.",
            "1.0.0",
            "",
            Contact("", "", ""),
            "", "", Collections.emptyList()
        )
    }

}
