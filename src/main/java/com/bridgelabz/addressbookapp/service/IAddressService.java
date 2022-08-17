package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.model.AddressModel;
import com.bridgelabz.addressbookapp.util.Response;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IAddressService {
    String getMessage();

    AddressModel addContact(AddressDTO addressDTO);

    AddressModel getContactById(Long id, AddressDTO addressDTO, String token);

    List<AddressModel> getAllContacts(String token);

    AddressModel deleteContact(Long id, String token);

    AddressModel updateContacts(long id, AddressDTO addressDTO);

    Response login(String emailId, String password);
}
