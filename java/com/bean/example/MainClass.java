package com.bean.example;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;

import com.bean.example.annotation.MyAutowired;
import com.bean.example.annotation.MyBean;
import com.bean.example.model.BeanClass1;
import com.bean.example.model.ExtendClass;

public class MainClass {


	
	@MyAutowired
	private Start start;
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

		
		Map<String,Object> applicationContest = init("com.bean.example");
		BeanClass1 bean1 = (BeanClass1) applicationContest.get(BeanClass1.class.getSimpleName());
		bean1.test();
	}
	
	private static Map<String,Object> init(String basePackage) throws IllegalArgumentException, IllegalAccessException {
		List<Class<?>> annotatedClasses;
		Map<String,Object> applicationContext = new HashMap<String, Object>();
		
		Reflections ref1 = new Reflections(basePackage);
		annotatedClasses = new ArrayList(ref1.getTypesAnnotatedWith(MyBean.class));
		System.out.println("Mybean class size : "+annotatedClasses.size());
		


		for (Class class1 : annotatedClasses) {
			//System.out.println(class1.getName()+" "+ class1.getPackageName() + " " + class1.getSimpleName() + " " + class1.getGenericSuperclass());
			try {
				newInstance(class1, applicationContext);
				
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
		
		for (Class class1 : annotatedClasses) {
			Field[] fieldList = class1.getDeclaredFields();
			for (Field field : fieldList) {
				MyAutowired autowired = field.getAnnotation(MyAutowired.class);
				if(autowired != null) {
					Class fieldClass = field.getType();
					String fieldTypeName = field.getType().getSimpleName();
					Object dependency = applicationContext.get(fieldTypeName);
					Object bean = applicationContext.get(class1.getSimpleName());
					field.setAccessible(true);
					field.set(bean, dependency);
					//declaredField.set(this, concHashMap);

				}
			}
		}
		return applicationContext;
	}
	
	private static void newInstance(Class class1, Map<String,Object> applicationContext) throws InstantiationException, IllegalAccessException {
		Object o = class1.newInstance();
		applicationContext.put(class1.getSimpleName(), o);
	}
}