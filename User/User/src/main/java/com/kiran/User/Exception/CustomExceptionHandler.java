package com.kiran.User.Exception;

import com.kiran.User.Entity.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserCustomExceptionFound.class)
    @ResponseBody
    public ErrorResponse handleUserCustomExceptionFound(UserCustomExceptionFound userCustomExceptionFound){
        return new ErrorResponse(userCustomExceptionFound.getMessage());
    }
}
