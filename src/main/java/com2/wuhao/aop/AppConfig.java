package com2.wuhao.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com2.wuhao.aop")
@EnableAspectJAutoProxy //开启spring对AspectJ代理的支持
public class AppConfig {


}
