package com.itcast.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestServiceImpl implements TestService {
	
	private TestDao dao;
	public void setDao(TestDao dao) {
		this.dao = dao;
	}

	/**
	 * 测试存储
	 */
	public void save() {
		System.out.println("Service层的save方法执行");
		dao.save();
	}

	@Override
	public void save(User user) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			dao.save(user);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

}
