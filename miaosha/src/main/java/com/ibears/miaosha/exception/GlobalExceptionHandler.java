package com.ibears.miaosha.exception;

import com.ibears.miaosha.result.CodeMassage;
import com.ibears.miaosha.result.Result;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author xiaoxiong
 * @date 2018/12/30 20:14
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    
    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e) {
        if (e instanceof GlobalException) {
            GlobalException  error =  (GlobalException)e;
            return Result.erro(error.getCodeMassage());
        } else if (e instanceof BindException) {
            List<ObjectError> errors         = ((BindException) e).getAllErrors();
            ObjectError       error          = errors.get(0);
            String            defaultMessage = error.getDefaultMessage();
            return Result.erro(CodeMassage.BIND_ERROR.fillArgs(defaultMessage));
        } else {
            return Result.erro(CodeMassage.SERVER_ERROR);
        }
    }
}
