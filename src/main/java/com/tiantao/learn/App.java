package com.tiantao.learn;

import com.tiantao.learn.spring.ioc.Bean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        Bean bean  = (Bean) ctx.getBean("bean");
        bean.print();
    }
}
