package com.jiaoshen.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiaoshen.dto.MyDomain;
import com.jiaoshen.dto.User;
import com.jiaoshen.enpty.OtherUser;
import com.jiaoshen.entity.newuser.NewUser;
import com.jiaoshen.service.Bdao;

/**
 * SpringMVC数据传输
 * 
 * @author jiaoshen
 * @date 2018年3月25日
 */
@Controller
@RequestMapping("/receive")
public class SpringMVCReceive {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
     Bdao bdao;
	/*
	 * 1.方法加参数接受
	 * http://localhost:8080/ssmDemo/receive/receive1.do?name=jiaoshen&age=20
	 */
	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	@ResponseBody
	public String test() {
		bdao.fn();
		return "okok";
	}

	@RequestMapping(value = "/receive1.do", method = RequestMethod.GET)
	@ResponseBody
	public String receive1(Integer age, String name, HttpServletRequest request) {
		User user = new User();
		user.setAge(age);
		user.setName(name);
		logger.debug("user==" + user);
		return "receive1name==" + user;
	}

	/*
	 * 2.简单对象接收
	 * http://localhost:8080/ssmDemo/receive/receive2.do?name=jiaoshen&age=20
	 */
	@RequestMapping(value = "/receive2.do", method = RequestMethod.GET)
	@ResponseBody
	public String receive2(User user, HttpServletRequest request) {

		return "receive2user==" + user;
	}

	/*
	 * 3.通过HttpSevletRequest对象接收
	 * http://localhost:8080/ssmDemo/receive/receive3.do?name=jiaoshen&age=20
	 */
	@RequestMapping(value = "/receive3.do", method = RequestMethod.GET)
	@ResponseBody
	public String receive3(HttpServletRequest request) {

		User user = new User();
		user.setAge(Integer.valueOf(request.getParameter("age")));
		user.setName(request.getParameter("name"));
		return "receive3user==" + user;
	}

	/*
	 * 4.通过PathVariabe获取路径的参数
	 * http://localhost:8080/ssmDemo/receive/receive4.do/jiaoshen/34
	 */
	@RequestMapping(value = "/receive4.do/{name}/{age}", method = RequestMethod.GET)
	@ResponseBody
	public String receive4(@PathVariable(value = "age") Integer age, @PathVariable(value = "name") String name) {
		User user = new User();
		user.setAge(age);
		user.setName(name);
		logger.debug("user==" + user);
		return "receive4name==" + user;
	}

	/*
	 * 5 .通过RequestParam获取路径的参数
	 * http://localhost:8080/ssmDemo/receive/receive5.do?name=jiaoshen&age=20
	 */
	@RequestMapping(value = "/receive5.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> receive5(@RequestParam("name") String name, @RequestParam("age") Integer age,
			HttpServletRequest request) {

		User user = new User();
		user.setAge(age);
		user.setName(name);
		logger.debug("user==" + user);
		// return "receive5name=="+user;
		Map<String, Object> m1 = new HashMap<String, Object>();
		List<String> l1 = new ArrayList<String>();
		l1.add("12345");
		l1.add("asdasd");
		l1.add("asdasd123");
		m1.put("user", user);
		m1.put("list", l1);
		return m1;
	}

	/*
	 * 多个属性的简单对象
	 * 
	 */
	@RequestMapping(value = "/receive6.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> receive6(@RequestBody List<OtherUser> newUserlist, HttpServletRequest request) {
		// User user=new User();
		// user.setAge();
		// user.setName(newUser.getName());
		OtherUser newUser = newUserlist.get(0);
		logger.debug("user==" + newUser);
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("user", newUser);
		return m1;
	}

	/*
	 * 多个属性的简单对象 json传
	 * 
	 */
	@RequestMapping(value = "/receive7.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> receive7(@RequestBody Map<String, Object> map1, HttpServletRequest request) {
		Integer age = (Integer) map1.get("age");
		List<String> name = (List<String>) map1.get("name");
		User user = new User();
		user.setAge(age);
		if (name != null) {
			user.setName(name.get(0));
		}
		logger.debug("user==" + user);
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("user", user);
		return m1;
	}

	@RequestMapping(value = "/wabiaozai.do", method = RequestMethod.POST)
	@ResponseBody
	public void myDomain(HttpServletRequest request, @RequestBody String myDomain) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		@SuppressWarnings("deprecation")
		JavaType javaType = objectMapper.getTypeFactory().constructParametrizedType(List.class, List.class,
				NewUser.class);
		List<NewUser> user1 = objectMapper.readValue(myDomain, javaType);

		//NewUser user1 = objectMapper.readValue(myDomain, NewUser.class);
		// System.out.println(user1);
		System.out.println(myDomain);
	}

}
