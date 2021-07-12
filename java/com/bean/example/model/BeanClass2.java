package com.bean.example.model;

import com.bean.example.annotation.MyAutowired;
import com.bean.example.annotation.MyBean;

@MyBean
public class BeanClass2 {
	@MyAutowired
	private BeanClass3 beanClass3;
	
 
	public void test() {
		System.out.println("beanClass2");
		beanClass3.test();
		
	}

}