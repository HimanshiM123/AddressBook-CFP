package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private String firstName;
    private String lastName;
    private String address;
    private String state;
    private String city;
    private int zip;
    private long phone;
    private String emailId;
    private String password;
}
