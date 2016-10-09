package com.itcast.crm.customer.web;

import javax.annotation.Resource;

import com.itcast.crm.customer.domain.Customer;
import com.itcast.crm.customer.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private static final long serialVersionUID = 1L;
	
	@Resource(name="customer")
	private Customer customer;
	public Customer getModel() {
		return customer;
	}
	@Resource(name="customerService")
	private CustomerService service;
	

	public String addSubmit() {
		service.save(customer);
		return null;
	}
	/**
	 * 跳转到添加客户页面
	 * @return
	 */
	public String initAdd()  {
		return "initAdd";
	}
	
	/**
	 * 关于懒加载的问题的演示和解决
	 * @return
	 */
	public String testLazy(){
		customer.setCust_id(1l);
		customer = service.findByIdForLoad(customer);
		System.out.println(customer.getCust_name());
		
		return null;
	}
	
}
