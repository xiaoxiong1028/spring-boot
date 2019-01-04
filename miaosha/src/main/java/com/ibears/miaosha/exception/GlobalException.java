package com.ibears.miaosha.exception;

import com.ibears.miaosha.result.CodeMassage;

/**
 * @author xiaoxiong
 * @date 2019/1/4 23:33
 */
public class GlobalException extends RuntimeException {
    
    private static final long serialVersionUID = 1593939933098965739L;
    
    private CodeMassage codeMassage;
    
    public GlobalException(CodeMassage codeMassage) {
        super(codeMassage.toString());
        this.codeMassage = codeMassage;
    }
    
    public CodeMassage getCodeMassage() {
        return codeMassage;
    }
}
