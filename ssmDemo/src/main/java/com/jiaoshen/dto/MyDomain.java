package com.jiaoshen.dto;

/**
 * 
 * @author jiaoshen
 * @date   2018年3月26日
 */
public class MyDomain {
  private String name;
  private String pwd;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}

public MyDomain() {
	super();
}
public MyDomain(String name, String pwd) {
	super();
	this.name = name;
	this.pwd = pwd;
}
  
}
