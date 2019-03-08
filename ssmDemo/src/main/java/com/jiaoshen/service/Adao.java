package com.jiaoshen.service;

import org.springframework.stereotype.Component;

@Component
public class Adao {
	private int  a=12;
	public Adao() {
		System.out.println("构造函数");
	}
	public int getA() {
		return a;
	}

}
