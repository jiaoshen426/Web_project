package com.jiaoshen.enpty;

import java.util.List;
import java.util.Map;

import com.jiaoshen.entity.newuser.Account;

public class OtherUser {
	private String name;
	
	private Integer age;
	
	private Account account;
    
	private Map<String,String> map1;
	
	
	
	public Map<String, String> getMap1() {
		return map1;
	}

	public void setMap1(Map<String, String> map1) {
		this.map1 = map1;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "OtherUser [name=" + name + ", age=" + age + ", account=" + account + ", map1=" + map1 + "]";
	}

	

	
	
	

}
