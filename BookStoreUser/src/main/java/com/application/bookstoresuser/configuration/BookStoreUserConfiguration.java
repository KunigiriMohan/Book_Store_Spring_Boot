/*
package com.application.bookstoresuser.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class BookStoreUserConfiguration {

    @Bean
    public Docket postApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Book Store User Micro Service").apiInfo(apiInfo()).select().paths(regex(".*")).build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Book Store User Service")
                .description("Swagger for Book Store User Micro Service ")
                .termsOfServiceUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ")
                .license("Book Sore User Micro Services Swager")
                .licenseUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ").version("1.0").build();
    }
}
*/
