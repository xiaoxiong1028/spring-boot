package com.ibears.miaosha.validatior;

import com.alibaba.druid.util.StringUtils;
import com.ibears.miaosha.util.ValidtaorUtil;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author xiaoxiong
 * @date 2019/1/4 23:16
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {
    
    
    private boolean required = true;
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (required) {
            return ValidtaorUtil.isMobile(value);
        } else {
            if (StringUtils.isEmpty(value)) {
                return true;
            } else {
                return ValidtaorUtil.isMobile(value);
            }
        }
        
    }
    
    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }
}
