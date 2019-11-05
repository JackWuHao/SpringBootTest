package com.wuhao.scope;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        DemoSingletonService singletonService = context.getBean(DemoSingletonService.class);
        DemoSingletonService s2 = context.getBean(DemoSingletonService.class);
        DemoprototyService p1 = context.getBean(DemoprototyService.class);
        DemoprototyService p2 = context.getBean(DemoprototyService.class);
        System.out.println("sinleton 与p1是否相等"+ singletonService.equals(s2));
        System.out.println("p2与p1是否相等"+ p1.equals(p2));
        context.close();
    }

}
