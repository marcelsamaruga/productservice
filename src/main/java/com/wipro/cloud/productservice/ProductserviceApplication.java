package com.wipro.cloud.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@EnableEurekaClient
public class ProductserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
    }

    /*@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Products").select()
                .apis(RequestHandlerSelectors.basePackage("com.wipro.cloud.productservice"))
                .paths(any()).build().apiInfo(getApiInfo());
    }*/

    private ApiInfo getApiInfo() {
        /*return new ApiInfo("Product Services", "A set of services to provide data access to products", "1.0.0", null,
                new Contact("Tech Specialist Team", null, null), null, null, Collections.emptyList());*/
        return null;
    }
}

