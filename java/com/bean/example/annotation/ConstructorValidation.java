package com.bean.example.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bean.example.model.ExtendClass;

public class ConstructorValidation implements  ConstraintValidator<MyBean, ExtendClass> {
	private static ExtendClass obj=new ExtendClass();
	
	public boolean isValid(ExtendClass value, ConstraintValidatorContext context) {
		if(value == null)
			value = obj;
		return true;
	}

}
