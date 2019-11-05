package com.wuho.cn;
import  org.springframework.stereotype.Service;
@Service  //声明ben
public class FunctionService {

    public String sayHello(String word) {
        return "Hello" + "world" + "!";
    }

}
