package com.poppy.ioc._6_import;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void beans() throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Object bean1 = context.getBean(CustomFactoryBean.class);
        Object bean2 = context.getBean(CustomFactoryBean.class);//取Money
        System.out.println("bean的类型="+bean1.getClass());
        System.out.println(bean1 == bean2);

        String[] beans = context.getBeanDefinitionNames();
        for (String b : beans) {
            System.out.println(b);//全路径：com.poppy.ioc._1_pojo.Dog
        }
    }
    @Test
    public void test2(){
        ClassPathResource resource = new ClassPathResource("beans.xml"); // <1>
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory(); // <2>
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory); // <3>
        reader.loadBeanDefinitions(resource);

    }

}