package com.green.greengram3.common;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){

        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Greengram Ver.3")
                        .description("인스타 클론 코딩")
                        .version("3.0.0")); //apiInfo() 아래 메소드 호출 , info메소드 파라미터 타입은 info반환타입이 아래의 info라서
    }

}
