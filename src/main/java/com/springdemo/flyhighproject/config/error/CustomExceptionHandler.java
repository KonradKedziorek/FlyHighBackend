package com.springdemo.flyhighproject.config.error;

import com.springdemo.flyhighproject.config.error.response.ConstraintViolationResponse;
import com.springdemo.flyhighproject.config.error.response.MethodArgumentNotValidResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@SuppressWarnings({"unchecked","rawtypes"})
@PropertySource("classpath:messages.properties")
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Value("${validationFailed}")
    private String validationFailed;


//    @ExceptionHandler({ ConstraintViolationException.class })
//    public ResponseEntity handleConstraintViolation(
//            ConstraintViolationException ex) {
//        List<String> details = new ArrayList<>();
//        for (ConstraintViolation<?> error : ex.getConstraintViolations()) {
//            details.add(error.getMessage());
//        }
//        ConstraintViolationResponse constraintViolationResponse =
//                new ConstraintViolationResponse("validationFailed" ,details, HttpStatus.BAD_REQUEST.value());
//        return new ResponseEntity<Object>(constraintViolationResponse, HttpStatus.BAD_REQUEST);
//    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<String> details = new ArrayList<String>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            details.add(error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            details.add(error.getDefaultMessage());
        }
        MethodArgumentNotValidResponse methodArgumentNotValidResponse = new MethodArgumentNotValidResponse(validationFailed, details, HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<Object>(methodArgumentNotValidResponse, HttpStatus.BAD_REQUEST);
    }

}
