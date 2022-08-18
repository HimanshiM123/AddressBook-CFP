package com.bridgelabz.addressbookapp.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private String message;
    private int errorCode;
    private Object data;
    
    public Response() {
    }

    public Response(String login_successful, String token) {
    }

    public Response(String loginSuccess, int i) {
    }
}
