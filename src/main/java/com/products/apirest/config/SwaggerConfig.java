package com.products.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfig {

    //access documentation
    //http://localhost:8080/swagger-ui/index.html
    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.products.apirest"))
                .paths(regex("/api.*")).build().apiInfo(metaInfo());
    }
    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "Produtos API REST",
                "API REST para cadastro de produtos",
                "version 1.0",
                "terms of service",
                new Contact("Octavius luís", "www.linkedin.com/in/otavio241","nickalex241@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );
        return apiInfo;

    }
}
