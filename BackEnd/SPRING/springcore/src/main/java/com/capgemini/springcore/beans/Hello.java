package com.capgemini.springcore.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Hello {//implements InitializingBean,DisposableBean {
	
	public Hello()
	{
	System.out.println("Object Created");
	}
	
	public Hello(String message,int count)
	{
		this.message=message;
		this.count=count;
	}
	private String message;
	private int count;
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(" afterPropertiesSet");
		
	}*/
	@PostConstruct //after construction of object use init()
	public void init()
	{
		System.out.println("init method");
	}
	@PreDestroy //before destroying the method use destroy()
	public void destroy()
	{
		System.out.println("destroy method");
	}
	
	
	

}
