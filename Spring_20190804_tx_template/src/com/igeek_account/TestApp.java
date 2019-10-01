package com.igeek_account;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.igeek_account_service.AccountService;

public class TestApp {
	@Test
	public void test1() {
		String xmlPath="applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		AccountService bean = applicationContext.getBean("serviceId",AccountService.class);
		bean.transfer("jack", "rose", 1000);
	}
}
