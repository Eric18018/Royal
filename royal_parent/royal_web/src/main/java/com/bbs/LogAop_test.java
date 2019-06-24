package com.bbs;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect    //把当前类声明为切面类
public class LogAop_test {

	//需要封装的六个参数

	private String username;
	private String ip;
	private String url;
	private Long executionTime;
	private Class clazz;


}
