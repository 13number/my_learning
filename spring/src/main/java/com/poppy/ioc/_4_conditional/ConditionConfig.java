package com.poppy.ioc._4_conditional;

import com.poppy.ioc._1_bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {
	@Bean("person")
	public Person person(){
		System.out.println("�����������person.......");
		return new Person("person",20);
	}

	@Conditional(MacCondition.class)
	@Bean("lison")
	public Person lison(){
		System.out.println("�����������lison.......");
		return new Person("Lison",58);
	}
	@Conditional(LinCondition.class)
	@Bean("james")//bean�������е�IDΪjames, IOC����MAP,  map.put("id",value)
	public Person james(){
		System.out.println("�����������james.......");
		return new Person("james",20);
	}
	
}
