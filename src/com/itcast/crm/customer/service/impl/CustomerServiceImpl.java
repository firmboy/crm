package com.itcast.crm.customer.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.crm.customer.dao.CustomerDao;
import com.itcast.crm.customer.domain.Customer;
import com.itcast.crm.customer.service.CustomerService;

@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Resource(name="customerDao")
	private CustomerDao dao;
	
	@Override
	public void save(Customer customer) {
		dao.save(customer);
	}

	/**
	 * 懒加载测试
	 */
	public Customer findByIdForLoad(Customer customer) {
		return dao.findByIdForLoad(customer);
		
	}

}
