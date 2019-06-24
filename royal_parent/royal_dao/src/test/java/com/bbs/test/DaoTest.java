package com.bbs.test;

import com.bbs.dao.ArticleDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {
    @Test
    public void test01() throws Exception{
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:applicationContext_dao.xml");
        ArticleDao articleDao = ioc.getBean(ArticleDao.class);

    }
}
