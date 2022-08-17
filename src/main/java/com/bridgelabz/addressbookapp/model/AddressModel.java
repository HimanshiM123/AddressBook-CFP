package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="addressbook")
@Data
public class AddressModel {
    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    private String address;
    private String state;
    private String city;
    private int zip;
    private long phone;

    public AddressModel(AddressDTO addressDTO) {
        this.fullName=addressDTO.getFullName();
        this.address=addressDTO.getAddress();
        this.state=addressDTO.getState();
        this.city=addressDTO.getCity();
        this.zip=addressDTO.getZip();
        this.phone=addressDTO.getPhone();

    }

    public AddressModel() {

    }
}
