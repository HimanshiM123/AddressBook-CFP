package com.bridgelabz.addressbookapp.exception.exceptionhandler;

import com.bridgelabz.addressbookapp.exception.AddressBookNotFoundException;
import com.bridgelabz.addressbookapp.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AddressBookExceptionHandler {
    @ExceptionHandler(AddressBookNotFoundException.class)
    public ResponseEntity<Response> handleHiringException(AddressBookNotFoundException he){
        Response response=new Response("LoginSuccess", 200);
        response.setErrorCode(400);
        response.setMessage(he.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
