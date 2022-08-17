package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.model.AddressModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IAddressService {
    String getMessage();

    List<AddressModel> getListContacts();

    AddressModel getContactById(long getId);

    void deleteContact(long id);

    String AddAddressBook(AddressDTO addressDTO);

    AddressModel updateAddressContact(long getId, AddressDTO addressDTO);
}
