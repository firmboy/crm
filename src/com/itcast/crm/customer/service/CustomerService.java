package com.itcast.crm.customer.service;

import com.itcast.crm.customer.domain.Customer;

public interface CustomerService {

	void save(Customer customer);

	Customer findByIdForLoad(Customer customer);

}
