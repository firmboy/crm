package com.itcast.test;

import org.hibernate.Session;

public class TestDaoImpl implements TestDao {

	public void save() {
		System.out.println("dao层的save方法执行了");		
	}


	public void save(User user) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(user);
		
	}

}
