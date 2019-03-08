package com.jiaoshen.dto;

/**
 * 
 * @author jiaoshen
 * @date 2018年3月25日
 */
public class User {
	private String name;
	private Integer age;
	private Address address;
   
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address add) {
		this.address = add;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", add=" + address + "]";
	}
  
	

}
