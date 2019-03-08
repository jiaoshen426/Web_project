package com.jiaoshen.dao;

import com.jiaoshen.enpty.User;

/**
 * 
 * @author jiaoshen
 * @date   2018年5月6日
 */
public interface UserMapper {
    int insert(User record);
    int insertSelective(User record);
}