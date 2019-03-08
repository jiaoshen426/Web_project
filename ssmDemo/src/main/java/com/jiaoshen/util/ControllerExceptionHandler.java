package com.jiaoshen.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionHandler {
	/**
	 * 当系统出现ServiceExceprion类型异常，会回调此方法，将异常封装到jsonresult
	 */
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public JsonResult handleServiceException(ServiceException e){
		return new JsonResult(e);
	}

}
