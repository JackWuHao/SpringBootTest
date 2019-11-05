package com.wuho.cn;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  //配置
@ComponentScan("com.wuho.cn") //自动扫描包名下的所有@Service @Compoent  @Repository  @Controller 的类，并注册为Bean

public class DIConfig {
}
