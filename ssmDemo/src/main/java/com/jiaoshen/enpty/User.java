package com.jiaoshen.enpty;

/**
 * 
 * @author jiaoshen
 * @date   2018年5月6日
 */
public class User {
    private String userId;

    private String userName;

    private String userOra;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserOra() {
        return userOra;
    }

    public void setUserOra(String userOra) {
        this.userOra = userOra == null ? null : userOra.trim();
    }
}