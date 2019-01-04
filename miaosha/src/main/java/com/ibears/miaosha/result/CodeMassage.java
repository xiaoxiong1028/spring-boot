package com.ibears.miaosha.result;

/**
 * @author xiaoxiong
 * @date 2018/12/24 20:46
 */
public class CodeMassage {
    
    private int code;
    
    private String codeMassage;
    
    
    /**
     * 通用异常
     */
    public static CodeMassage SUCCESS = new CodeMassage(0, "success");
    public static CodeMassage SERVER_ERROR = new CodeMassage(500100, "服务端异常");
    public static CodeMassage BIND_ERROR = new CodeMassage(500101, "参数校验异常:%s");
    
    
    /**
     * 500200
     * 登陆异常
     */
    public static CodeMassage SESSION_ERROR = new CodeMassage(500210, "session不存在或已失效");
    public static CodeMassage PASSWORD_EMPTY = new CodeMassage(500211, "密码不能为空");
    public static CodeMassage MOBILE_EMPTY = new CodeMassage(500212, "手机号不能为空");
    public static CodeMassage MOBILE_ERROR = new CodeMassage(500213, "手机号格式");
    public static CodeMassage MOBILE_NOT_EXIST = new CodeMassage(500214, "该用户不存在");
    public static CodeMassage PASSWORD_ERROR = new CodeMassage(500215, "密码错误");
    
    
    /**
     * 500300
     *
     */
    
    
    /**
     * 500400
     *
     */
    
    
    /**
     * 500500
     */
    
    
    public CodeMassage(int code, String codeMassage) {
        this.code = code;
        this.codeMassage = codeMassage;
    }
    
    public CodeMassage fillArgs(Object... objects) {
        int    code    = this.code;
        String message = String.format(this.codeMassage, objects);
        return new CodeMassage(code, message);
    }
    
    public int getCode() {
        return code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public String getCodeMassage() {
        return codeMassage;
    }
    
    public void setCodeMassage(String codeMassage) {
        this.codeMassage = codeMassage;
    }
}
