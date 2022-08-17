package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressModel;
import com.bridgelabz.addressbookapp.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ResponseDTO> AddContact(@RequestBody AddressDTO addressDTO){
        String AddContact=addressService.AddAddressBook(addressDTO);
        ResponseDTO responseDTO = new ResponseDTO("Contact added successfully", AddContact);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getcontact/{getId}")
    public ResponseEntity<ResponseDTO> getContact(@PathVariable long getId)
    {
        AddressModel addressModel = addressService.getContactById(getId);
        ResponseDTO responseDTO = new ResponseDTO("Getting contact by id successfully", addressModel);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getcontacts")
    public ResponseEntity<ResponseDTO> getContacts()
    {
        List<AddressModel> addressModel = addressService.getListContacts();
        ResponseDTO responseDTO = new ResponseDTO("Got list of contacts successfully", addressModel);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteContact(@RequestParam long id){
        addressService.deleteContact(id);
        ResponseDTO responseDTO = new ResponseDTO("Contact Deleted Successfully", id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @PutMapping("/updatecontact/{getId}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable long getId, @RequestBody AddressDTO addressDTO){
        AddressModel updateContact = addressService.updateAddressContact(getId,addressDTO);
        ResponseDTO responseDTO = new ResponseDTO("Contact Updated successfully", updateContact);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

}
