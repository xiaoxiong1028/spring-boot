package com.ibears.miaosha.result;

/**
 * @author xiaoxiong
 * @date 2018/12/24 20:41
 */
public class Result<T> {
    
    
    private int code;
    
    private String msg;
    
    private T data;
    
    public Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }
    
    public Result(CodeMassage massage) {
        if (null == massage) {
            return;
        }
        this.code = massage.getCode();
        this.msg = massage.getCodeMassage();
        this.data = null;
    }
    
    /***
     * 成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }
    
    /**
     * 失败
     *
     * @param massage
     * @param <T>
     * @return
     */
    public static <T> Result<T> erro(CodeMassage massage) {
        return new Result<>(massage);
    }
    
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
}
