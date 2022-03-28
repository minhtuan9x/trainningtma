package com.dominhtuan.exercise1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
//    @Bean
//    public Docket docket(){//return builder patten
//            return new Docket(DocumentationType.SWAGGER_2)//swagger version
//                    .select()
//                    .apis(RequestHandlerSelectors.any())
//                    .paths(PathSelectors.any())
//                    .build();
//    }
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("com.dominhtuan.exercise1"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfo("User Api",
                "Restful Api for User",
                "1.0",
                "Free to use",
                "Tuan Do Minh",
                "dmtuan2@tma.com.vn",
                "dmtuan2@tma.com.vn"
                );
    }
}
