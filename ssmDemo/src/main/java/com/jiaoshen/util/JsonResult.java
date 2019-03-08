package com.jiaoshen.util;
/**
 * 
 * @author jiaoshen
 * Json形式封装与页面交互的数据
 */
public class JsonResult {
	private static final int SUCCESS=1;
	private static final int ERROR=0;
	/*状态*/
	private int state;
	/*对于状态的信息*/
	private String message;
	
	private Object data;
	
	/*没有数据返回的情景*/
	public JsonResult(){
		state=SUCCESS;
		message="ok";
	}
	/*有数据返回的情景*/
	public JsonResult(Object data){
		this();
		this.data=data;
	}
	/*出现异常后的情景*/
	public JsonResult(Throwable t){
		this.message=t.getMessage();
		this.state=ERROR;
	}
	/*出现异常后加数据的情景*/
	public JsonResult(Throwable t,Object data){
		this.message=t.getMessage();
		this.data=data;
		this.state=ERROR;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	

}
