package com.wuhao.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")  /*每次调用新建一个Bean实例  （"request"） :web项目中每次一个HTTP request 新建一个Bean实例   （"session"）:
每次一个http Session 新建一个Bean实例  （"globalSession"）:这个只在portal应用中有效，每次一个globalSession 新建一个Bean实例  */
public class DemoprototyService {

}
