package com.bridgelabz.addressbookapp.exception;

public class AddressBookNotFoundException extends RuntimeException {
    private int statusCode;
    private String statusMessage;

   public AddressBookNotFoundException(int statusCode, String statusMessage){
        super(statusMessage);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
