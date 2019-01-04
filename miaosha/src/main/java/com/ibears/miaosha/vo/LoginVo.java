package com.ibears.miaosha.vo;

import com.ibears.miaosha.validatior.IsMobile;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * @author xiaoxiong
 * @date 2018/12/29 13:15
 */
public class LoginVo {
    
    @NotNull
    @IsMobile
    private String mobile;
    
    @NotNull
    @Length(min = 6)
    private String password;
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "LoginVo{" +
              "mobile='" + mobile + '\'' +
              ", password='" + password + '\'' +
              '}';
    }
}

