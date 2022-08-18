package com.bridgelabz.addressbookapp.exception.exceptionhandler;

import com.bridgelabz.addressbookapp.exception.AddressBookNotFoundException;
import com.bridgelabz.addressbookapp.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
public class AddressBookExceptionHandler {
    @ExceptionHandler(AddressBookNotFoundException.class)
    public ResponseEntity<Response> handleHiringException(AddressBookNotFoundException he){
        Response response=new Response("LoginSuccess", 200);
        response.setErrorCode(400);
        response.setMessage(he.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
