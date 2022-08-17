package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.model.AddressModel;
import com.bridgelabz.addressbookapp.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AddressService implements IAddressService{
    @Autowired
    IAddressRepository repository;
    @Override
    public String getMessage() {
        return "Welcome to Address Book";
    }
    @Override
    public List<AddressModel> getListContacts() {
        List<AddressModel> addressModels = repository.findAll();
        return addressModels;
    }
    @Override
    public AddressModel getContactById(long getId) {
        Optional<AddressModel> addressModel = repository.findById(getId);
        return addressModel.get();
    }
    @Override
    public void deleteContact(long id) {
        repository.deleteById(id);
    }
    @Override
    public String AddAddressBook(AddressDTO addressDTO) {
        AddressModel addressModel=new AddressModel(addressDTO);
        repository.save(addressModel);
        return addressModel.toString();
    }
    @Override
    public AddressModel updateAddressContact(long getId, AddressDTO addressDTO) {
        Optional<AddressModel> newContact = repository.findById(getId);
        if (newContact.isPresent()) {
            newContact.get().setFullName(addressDTO.getFullName());
            newContact.get().setAddress(addressDTO.getAddress());
            newContact.get().setCity(addressDTO.getCity());
            newContact.get().setState(addressDTO.getState());
            newContact.get().setZip(addressDTO.getZip());
            newContact.get().setPhone(addressDTO.getPhone());
            repository.save(newContact.get());
            return newContact.get();
        } else {
            return null;
        }
    }
}
