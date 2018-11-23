package cn.novedu.validation.validator;


import cn.novedu.validation.MaxLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 最大长度注解验证器
 *
 * @author huangyong
 * @since 1.0.0
 */
public class MaxLengthValidator implements ConstraintValidator<MaxLength, String> {

    private int length;

    @Override
    public void initialize(MaxLength constraintAnnotation) {
        length = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.length() <= length;
    }
}
