package com.bean.example.model;

import com.bean.example.annotation.MyAutowired;
import com.bean.example.annotation.MyBean;

@MyBean
public class BeanClass1 extends ExtendClass {

	@MyAutowired
	private BeanClass2 beanClass2;
	
 
	public void test() {
		System.out.println("beanClass1");
		beanClass2.test();
	}
}
