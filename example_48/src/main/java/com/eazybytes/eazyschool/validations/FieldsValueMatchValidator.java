package com.eazybytes.eazyschool.validations;

import com.eazybytes.eazyschool.annotation.FieldsValueMatch;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch, Object> {

    private String field;
    private String fieldMatch;

    @Override
    public void initialize(FieldsValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        Object fieldValueMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);

/*        if(fieldValue != null){
            if(fieldValue.toString().startsWith("$2a")){
                return true;
            } else if (fieldValue.equals(fieldValueMatchValue)){
                return true;
            } else {
                return fieldValueMatchValue == null;
            }
        }
        return true;*/

        if(fieldValue != null){
            return fieldValue.equals(fieldValueMatchValue);
        } else {
            return fieldValueMatchValue == null;
        }
    }

}
