package com.itcast.crm.customer.dao;

import com.itcast.crm.customer.domain.Customer;

public interface CustomerDao {

	void save(Customer customer);

	Customer findByIdForLoad(Customer customer);

}
