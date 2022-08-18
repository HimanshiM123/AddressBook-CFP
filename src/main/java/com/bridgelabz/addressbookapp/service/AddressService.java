package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookNotFoundException;
import com.bridgelabz.addressbookapp.model.AddressModel;
import com.bridgelabz.addressbookapp.repository.IAddressRepository;
import com.bridgelabz.addressbookapp.util.Response;
import com.bridgelabz.addressbookapp.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService{
    @Autowired
    IAddressRepository repository;
    @Autowired
    MailService mailService;
    @Autowired
    TokenUtil tokenUtil;
    @Override
    public String getMessage() {

        return "Welcome to Address Book";
    }

    @Override
    public AddressModel addContact(AddressDTO addressDTO) {
        AddressModel addressModel = new AddressModel(addressDTO);
        addressModel.setRegisterDate(LocalDateTime.now());
        repository.save(addressModel);
        String body = "Contact added Successfully with Contact id  :" + addressModel.getId();
        String subject = "Contact added Successfully....";
        mailService.send(addressModel.getEmailId(), body, subject);
        return addressModel;
    }

    @Override
    public AddressModel getContactById(Long id, AddressDTO addressDTO, String token) {
        Long contactId = tokenUtil.decodeToken(token);
        Optional<AddressModel> isContact = repository.findById(contactId);
        if (isContact.isPresent()) {
            Optional<AddressModel> isContactPresent = repository.findById(id);
            if (isContactPresent.isPresent()) {
                return isContactPresent.get();
            } else {
                throw new AddressBookNotFoundException(400, "Contact not found");
            }
        }
        throw new AddressBookNotFoundException(400, "Contact is Wrong");
    }

    @Override
    public List<AddressModel> getAllContacts(String token) {
        Long contactId = tokenUtil.decodeToken(token);
        Optional<AddressModel> isContactIsPresent = repository.findById(contactId);
        if (isContactIsPresent.isPresent()) {
            List<AddressModel> isContactPresent = repository.findAll();
            if (isContactPresent.size() > 0) {
                return isContactPresent;
            } else {
                throw new AddressBookNotFoundException(400, "No Contacts Is there");
            }
        }
        throw new AddressBookNotFoundException(400, "Token is wrong");
    }

    @Override
    public AddressModel deleteContact(Long id, String token) {
        Long contactId = tokenUtil.decodeToken(token);
        Optional<AddressModel> isContact = repository.findById(contactId);
        if (isContact.isPresent()) {
            Optional<AddressModel> isContactPresent = repository.findById(id);
            if (isContactPresent.isPresent()) {
                repository.delete(isContactPresent.get());
                String body = "Contact Deleted Successfully with Contact id :" + isContactPresent.get().getId();
                String subject = "Contact Deleted Successfully....";
                mailService.send(isContactPresent.get().getEmailId(), body, subject);
                return isContactPresent.get();
            } else {
                throw new AddressBookNotFoundException(400, "Contact not Found");
            }
        }
        throw new AddressBookNotFoundException(400, "Token is wrong");
    }

    @Override
    public AddressModel updateContacts(long id, AddressDTO addressDTO) {
        Optional<AddressModel> isContact = repository.findById(id);
        if (isContact.isPresent()) {
            Optional<AddressModel> isContactPresent = repository.findById(id);
            if (isContactPresent.isPresent()) {
                isContactPresent.get().setFirstName(addressDTO.getFirstName());
                isContactPresent.get().setLastName(addressDTO.getLastName());
                isContactPresent.get().setAddress(addressDTO.getAddress());
                isContactPresent.get().setCity(addressDTO.getCity());
                isContactPresent.get().setState(addressDTO.getState());
                isContactPresent.get().setPhone(addressDTO.getPhone());
                isContactPresent.get().setZip(addressDTO.getZip());
                isContactPresent.get().setUpdatedDate(LocalDateTime.now());
                repository.save(isContactPresent.get());
                String body = "Contact Updated Successfully with Contact id  :" + isContactPresent.get().getId();
                String subject = "Contact Updated Successfully....";
                mailService.send(isContactPresent.get().getEmailId(), body, subject);
                return isContactPresent.get();
            } else {
                throw new AddressBookNotFoundException(400, "Contact is not Found");
            }
        }
        throw new AddressBookNotFoundException(400, "Contact is wrong");
    }

    @Override
    public Response login(String emailId, String password) {
        Optional<AddressModel> isEmailPresent = repository.findByEmailId(emailId);
        if (isEmailPresent.isPresent()) {
            if (isEmailPresent.get().getPassword().equals(password)) {
                String token = tokenUtil.createToken(isEmailPresent.get().getId());
                return new Response("Login successful", token);
            } else {
                throw new AddressBookNotFoundException(400, "Password is wrong");
            }
        }
        throw new AddressBookNotFoundException(400, "No Contact Found");
    }
}
