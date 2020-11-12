package com.example.utils;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * Exception Util
 *
 * @author zhaoke
 * @since 2019/12/21
 **/
public class ExceptionUtils {

    private ExceptionUtils() {
    }

    public static Joiner joiner = Joiner.on(" | ").skipNulls();

    public static String buildConstraintViolationExceptionMessage(ConstraintViolationException constraintViolationException) {
        Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();
        if (CollectionUtil.isEmpty(constraintViolations)) {
            return null;
        }
        List<String> messages = Lists.newArrayListWithCapacity(constraintViolations.size());
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            messages.add(constraintViolation.getMessage());
        }
        return joiner.join(messages);
    }

    public static String buildMethodArgumentNotValidExceptionMessage(Exception exception) {
        BindingResult bindingResult = null;
        if (exception instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) exception;
            bindingResult = methodArgumentNotValidException.getBindingResult();
        } else if (exception instanceof BindException) {
            BindException bindException = (BindException) exception;
            bindingResult = bindException.getBindingResult();
        }
        if (bindingResult == null) {
            return null;
        }
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if (CollectionUtil.isEmpty(allErrors)) {
            return null;
        }
        List<String> messages = Lists.newArrayListWithCapacity(allErrors.size());
        for (ObjectError error : allErrors) {
            FieldError fieldError = (FieldError) error;
            messages.add(fieldError.getDefaultMessage());
        }
        return joiner.join(messages);
    }
}