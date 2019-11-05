package com.wuho.cn;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {
    @Autowired  //使用bean
    FunctionService functionService;
    public String sayHello(String world) {
        return functionService.sayHello(world);
    }
}
