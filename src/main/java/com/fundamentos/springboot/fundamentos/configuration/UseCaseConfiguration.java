package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.UseCase.GetUser;
import com.fundamentos.springboot.fundamentos.UseCase.GetUserImplement;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
