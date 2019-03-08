package com.jiaoshen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Bdao {
	private int kk;
	@Autowired
	public Bdao(Adao adao) {
		System.out.println(adao.getA());
	}
	public void fn(){
		kk =kk+12;
		System.out.println("kk"+kk);
	}

}
