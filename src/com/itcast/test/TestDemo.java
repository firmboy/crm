package com.itcast.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class TestDemo {
	
	@Resource(name="testService")
	private TestService service;
	
	
	/**
	 * 测试 Hibernate框架、Spring整合Hibernate框架
	 */
	@Test
	public void test2(){
		User user = new User();
		user.setName("小泽");
		service.save(user);
	}
	
	/**
	 * 测试Spring的IOC功能和Aop功能
	 */
	@Test
	public void test1(){
		service.save();
	}
	
}
