package com.wuhao.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class JavaConfig {
    @Bean
    public  FunctionService functionService(){
        return  new FunctionService();
    }

    @Bean
    public UserFunctionService useFunctionService(){
        UserFunctionService userFunctionService = new UserFunctionService();
        userFunctionService.setFunctionService(functionService());

        return  userFunctionService;
    }


}
