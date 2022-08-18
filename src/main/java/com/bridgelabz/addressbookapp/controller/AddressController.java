package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.model.AddressModel;
import com.bridgelabz.addressbookapp.service.IAddressService;
import com.bridgelabz.addressbookapp.util.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/addressbook")
public class AddressController {

    @Autowired
    IAddressService addressService;

    @GetMapping("/hello")
    public String hello(){
        String message = addressService.getMessage();
        return message;
    }
    @PostMapping("/addcontact")
    public AddressModel addContact(@Valid @RequestBody AddressDTO addressDTO){

        return addressService.addContact(addressDTO);
    }
    @GetMapping("/getcontact/{getId}")
    public AddressModel getContactById( @PathVariable long id, @Valid @RequestBody AddressDTO addressDTO, @RequestHeader String token) {
        return addressService.getContactById(id, addressDTO, token);
    }

    @GetMapping("/getcontacts")
    public List<AddressModel> getContacts(@RequestHeader String token) {

        return addressService.getAllContacts(token);
    }

    @DeleteMapping("/delete")
    public AddressModel deleteContact(@PathVariable Long id, @RequestHeader String token){
        return addressService.deleteContact(id, token);
    }
    @PutMapping("/updatecontact/{getId}")
    public AddressModel updateContact(@PathVariable long id, @Valid @RequestBody AddressDTO addressDTO){
       return addressService.updateContacts(id, addressDTO);
    }
    @PostMapping("/login")
    public Response login(@RequestParam String emailId, @RequestParam String password) {
        return addressService.login(emailId, password);
    }

}
