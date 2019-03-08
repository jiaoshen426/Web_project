package com.jiaoshen.dto;

/**
 * 
 * @author jiaoshen
 * @date 2018年3月26日
 */
public class Address {
	private String add;
	private String code;

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Address [add=" + add + ", code=" + code + "]";
	}

}
