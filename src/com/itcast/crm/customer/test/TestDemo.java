package com.itcast.crm.customer.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itcast.crm.customer.domain.Customer;
import com.itcast.crm.customer.service.CustomerService;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class TestDemo {
	
	@Resource(name="customerService")
	private CustomerService service;
	
	@Test
	public void test1(){
		List<Customer> findAll = service.findAll();
		System.out.println(findAll);
	}
}
