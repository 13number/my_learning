package com.poppy.ioc._5_scope_lazy;

import com.poppy.ioc._1_bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class UseScope {
    //给容器中注册一个bean, 类型为返回值的类型, 默认是单实例
    /*
     * prototype:多实例: IOC容器启动的时候,IOC容器启动并不会去调用方法创建对象, 而是每次获取的时候才会调用方法创建对象
     * singleton:单实例(默认):IOC容器启动的时候会调用方法创建对象并放到IOC容器中,以后每次获取的就是直接从容器中拿(大Map.get)的同一个bean
     * request: 主要针对web应用, 递交一次请求创建一个实例
     * session:同一个session创建一个实例
     */
    @Scope("prototype")
    @Lazy //使用时在创建对象实例
    @Bean
    public Dog dog() {
        return new Dog("james");
    }
}

