package com.itcast.test;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao {

	public void save() {
		System.out.println("dao层的save方法执行了");		
	}


	public void save(User user) {
		this.getHibernateTemplate().save(user);		
	}

}
