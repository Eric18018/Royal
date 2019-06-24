package com.bbs.test;

import com.bbs.service.ArticleService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {

    @Test
    public void test01() throws Exception{
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:applicationContext_dao.xml");
        ArticleService articleService = ioc.getBean(ArticleService.class);

    }
}
