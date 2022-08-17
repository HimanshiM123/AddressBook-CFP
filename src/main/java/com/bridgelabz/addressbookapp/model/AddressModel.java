package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="addressbook")
@Data
public class AddressModel {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String address;
    private String state;
    private String city;
    private int zip;
    private long phone;
    private String emailId;
    private String password;
    private LocalDateTime registerDate;
    private LocalDateTime updatedDate;

    public AddressModel(AddressDTO addressDTO) {
        this.fullName=addressDTO.getFirstName();
        this.fullName=addressDTO.getLastName();
        this.address=addressDTO.getAddress();
        this.state=addressDTO.getState();
        this.city=addressDTO.getCity();
        this.zip=addressDTO.getZip();
        this.phone=addressDTO.getPhone();
        this.emailId=addressDTO.getEmailId();
        this.password=addressDTO.getPassword();
    }

    public AddressModel() {

    }
}
