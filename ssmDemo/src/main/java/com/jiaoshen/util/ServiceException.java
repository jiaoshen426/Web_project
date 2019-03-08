package com.jiaoshen.util;
@SuppressWarnings("serial")
public class ServiceException extends RuntimeException{
	
	public ServiceException(){
		super();
		
	}
	
	public ServiceException(String message,Throwable cause,boolean enableSuprression,boolean wirableStackTrace){
		super(message,cause,enableSuprression,wirableStackTrace);
	}
	
	public ServiceException(String message,Throwable cause){
		super(message,cause);
	}
	
	public ServiceException(String message){
		super(message);
	}
	
	public ServiceException(Throwable cause){
		super(cause);
	}
	
}
