package com.bean.example;

import com.bean.example.annotation.MyAutowired;
import com.bean.example.annotation.MyBean;
import com.bean.example.model.BeanClass1;
import com.bean.example.model.BeanClass3;
import com.bean.example.model.ExtendClass;

@MyBean
public class Start {
	@MyAutowired
	private BeanClass1 beanClass;
	@MyAutowired
	private BeanClass3 beanClass3;

	public Start() {
		this.init();

	}

	private void init() {

	}
}
