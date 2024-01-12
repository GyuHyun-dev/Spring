package com.yedam.app.spring;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		System.out.println("Spring 방식");
		
		GenericApplicationContext	
		ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		
		TV tv = (TV)ctx.getBean(TV.class);
		tv.on();

	}
}
