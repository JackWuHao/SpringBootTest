package com3.wuhao.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig resource = context.getBean(ElConfig.class);
        resource.outputResource();
        context.close();
    }
}
