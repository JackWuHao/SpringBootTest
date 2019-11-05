package com2.wuhao.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DemoAnnotationService service =  context.getBean(DemoAnnotationService.class);
        DemoMehtodService mehtodService = context.getBean(DemoMehtodService.class);
        service.add();
        mehtodService.add();
        context.close();

    }
}
