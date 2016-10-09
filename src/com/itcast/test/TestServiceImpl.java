package com.itcast.test;

import org.springframework.transaction.annotation.Transactional;

@Transactional
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
		dao.save(user);
	}

}
