package com.itcast.crm.customer.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itcast.crm.customer.dao.CustomerDao;
import com.itcast.crm.customer.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	
	
	/**
	 * 查询所有客户
	 */
	public List<Customer> findAll() {
		List<Customer> find = (List<Customer>)this.getHibernateTemplate().find("from Customer");
		return find;
	}
	/**
	 * 保存客户
	 */
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);	
	}

	/**
	 * 测试懒加载
	 */
	public Customer findByIdForLoad(Customer customer) {
		 customer = this.getHibernateTemplate().load(Customer.class, customer.getCust_id());
		return customer;
	}

	
	
	
	
}
