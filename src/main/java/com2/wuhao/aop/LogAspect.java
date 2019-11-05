package com2.wuhao.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect  //注释成为一个切面
@Component //成为管理spring容器的bean
public class LogAspect {
    @Pointcut("@annotation(com2.wuhao.aop.Action)")  //声明切点
    public void annotationPointCut(){ };
    @After("annotationPointCut()") //声明一个建言 ，并使用切点
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截"+ action.name()); //通过反射获取注解的属性，然后做日志记录
    };

    @Before("execution(* com2.wuhao.aop.DemoMehtodService.* (..))") //声明一个建言，并直接使用拦截器规则做参数(*后面有个空格)
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截"+ method.getName());
    }
}
