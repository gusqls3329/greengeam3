package com.green.greengram3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class CharEncodingConfig { //통합테스트에서 사용
    @Bean
    public CharacterEncodingFilter characterEncodingFilter(){
        return new CharacterEncodingFilter("UTF-8",true);
    }
}
