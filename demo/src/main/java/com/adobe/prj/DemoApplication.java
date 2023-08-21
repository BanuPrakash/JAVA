package com.adobe.prj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.adobe.prj.entity.Employee;
import com.adobe.prj.service.AppService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		
		String[] names = ctx.getBeanDefinitionNames(); 
		for(String name : names) {
			System.out.println(name);
		}
		
		Employee e = new Employee(); // not a bean
		AppService service = ctx.getBean("appService", AppService.class);
		service.insert(e);
	}

}
