package com.bridgelabz.addressbookapp.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private String message;
    private int errorCode;
    private Object token;

    public Response(String loginSuccess, int i) {

    }
}
