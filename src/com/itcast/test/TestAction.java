package com.itcast.test;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

//@Controller(value="testAction")
//@Scope(value="prototype")
public class TestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	//@Resource(name="testService")
	private TestService service;
	public void setService(TestService service) {
		this.service = service;
	}
	
	public String test() {
		System.out.println(this);
		System.out.println("hello");
		service.save();
		return null;
	}
	
}
