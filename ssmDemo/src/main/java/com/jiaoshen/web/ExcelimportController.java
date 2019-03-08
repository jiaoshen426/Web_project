package com.jiaoshen.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jiaoshen.dao.UserMapper;
import com.jiaoshen.dto.SeckillResult;
import com.jiaoshen.enpty.User;
import com.jiaoshen.service.SeckillService;
import com.jiaoshen.util.ImportExcelUntil;

/**
 * 
 * @author jiaoshen
 * @date   2018年5月6日
 */
@Controller
public class ExcelimportController {
	@Autowired
	UserMapper userMapper;
	
	
	@ResponseBody    
	@RequestMapping(value = "/improtExcel", method = { RequestMethod.POST })    
	public  SeckillResult<String> ImprotExcel(@RequestParam(value="uploadFile")MultipartFile file) {    
	    User  obj = new User ();    
	    try {    
	            
	        List<Map<String, Object>> list = ImportExcelUntil.importExcel(file, obj);    
	            
	        System.out.println(list);    
	    } catch (Exception e) {    
	        e.printStackTrace();    
	    }    
	        
	    //批量插入数据库    
	    User u1=new User();
	    u1.setUserId("11");
	    u1.setUserName("laoshern");
	    int ret=0;    
	    ret = userMapper.insert(u1);    
	    return new SeckillResult(true,"asfd");    
	}    

}
