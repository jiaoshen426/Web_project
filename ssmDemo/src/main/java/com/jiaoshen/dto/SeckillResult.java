package com.jiaoshen.dto;

/**
 * 
 * @author jiaoshen
 * @date 2018��1��6��
 */
public class SeckillResult<T> {
	private boolean success;

	private T data;

	private String error;

	public SeckillResult(boolean success, String error) {
		super();
		this.success = success;
		this.error = error;
	}

	public SeckillResult(boolean success, T data) {
		super();
		this.success = success;
		this.data = data;
	}

	public SeckillResult(boolean success, T data, String error) {
		super();
		this.success = success;
		this.data = data;
		this.error = error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
