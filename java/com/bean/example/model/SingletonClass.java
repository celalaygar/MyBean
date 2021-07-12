package com.bean.example.model;

public class SingletonClass {

	private static SingletonClass obj = new SingletonClass();

	private SingletonClass() {
	}

	public static SingletonClass getBaseClass() {
		return obj;
	}

	public void doSomething() {

	}
}
