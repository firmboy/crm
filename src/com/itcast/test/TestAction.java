package com.itcast.test;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String test() {
		System.out.println("hello");
		return null;
	}
	
}
