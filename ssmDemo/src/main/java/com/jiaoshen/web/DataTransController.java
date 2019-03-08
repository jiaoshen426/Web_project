package com.jiaoshen.web;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiaoshen.dto.MyDomain;
import com.jiaoshen.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * SpringMVC数据传输
 * @author jiaoshen
 * @date   2018年3月25日
 */
@Controller
@RequestMapping("/data")
public class DataTransController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value="/test.do",method=RequestMethod.GET)
	@ResponseBody
	public String test(User user,String newname,HttpServletRequest request){
		logger.debug("user.age=="+user.getAge());
		logger.debug("user.name=="+user.getName());
		logger.debug("user=="+user);
		return "name=="+user;
	}
	//基本类型
	@RequestMapping(value="/baseType.do",method=RequestMethod.POST)
	@ResponseBody
	public String baseType(User user,HttpServletRequest request){
		System.out.println("user.age=="+user.getAge());
		System.out.println("user.name=="+user.getName());
		System.out.println("user=="+user);
		return "name=="+user;
	}
	
	@RequestMapping(value = "/wabiaozai", method = RequestMethod.POST)
	@ResponseBody
    public  void myDomain(HttpServletRequest request, @RequestBody String myDomain) throws Exception{  
          
        ObjectMapper objectMapper = new ObjectMapper();  
        @SuppressWarnings("deprecation")
		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, MyDomain.class);  
        List<MyDomain> list = objectMapper.readValue(myDomain, javaType);  
      
        System.out.println("");    
    }  

}
