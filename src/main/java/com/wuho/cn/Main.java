package com.wuho.cn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        //声明 使用 AnnotationConfigApplicationContext 作为Spring的容器，接受输入一个配置类作为参数
        AnnotationConfigApplicationContext content = new AnnotationConfigApplicationContext(DIConfig.class);
        //获取声明的UseFunctionService 的bean
        UseFunctionService  useFunctionService =  content.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("di"));
        content.close();
    }
}
