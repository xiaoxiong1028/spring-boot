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
    public static CodeMassage SERVER_ERRO = new CodeMassage(500100, "服务端异常");
    
    /**
     * 500200
     * 登陆异常
     */
    
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
