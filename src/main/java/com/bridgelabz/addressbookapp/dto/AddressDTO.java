package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private String fullName;
    private String address;
    private String state;
    private String city;
    private int zip;
    private long phone;
}
