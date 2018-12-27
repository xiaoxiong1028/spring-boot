package com.ibears.miaosha.domain;

/**
 * @author xiaoxiong
 * @date 2018/12/27 21:35
 */

public class User {
    
    private Long userId;
    
    private String userName;
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public User() {
    }
    
    public User(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
