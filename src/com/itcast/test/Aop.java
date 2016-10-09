package com.itcast.test;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Aop {
	
	private Logger log = Logger.getLogger(Aop.class);
	
	@Before(value="execution(* com.itcast.test.*ServiceImpl.save*(..))")//拦截所有Service层的save方法
	public void logServiceSave(JoinPoint joinPoint){
		String string =joinPoint.getTarget().toString();
		log.info(string.substring(string.lastIndexOf(".")+1, string.indexOf("@"))+"的"+joinPoint.getSignature().getName()+"方法保存之前");
	}
	
	@After(value="execution(* com.itcast.test.*DaoImpl.save*(..))")//拦截dao层的save方法
	public void logDaoSave(JoinPoint joinPoint){
		String string =joinPoint.getTarget().toString();
		log.info(string.substring(string.lastIndexOf(".")+1, string.indexOf("@"))+"的"+joinPoint.getSignature().getName()+"方法保存之后");
	}
}
