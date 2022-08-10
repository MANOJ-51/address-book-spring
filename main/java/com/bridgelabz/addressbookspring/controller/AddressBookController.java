package com.bridgelabz.addressbookspring.controller;

import com.bridgelabz.addressbookspring.dto.AddressBookDTO;
import com.bridgelabz.addressbookspring.model.AddressBookModel;
import com.bridgelabz.addressbookspring.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

    @Autowired
    IAddressBookService iAddressBookService;
    @GetMapping("/welcome")
    public String welcomeMessage(){
        return "Welcome to Address Book Spring application";
    }

    //create
    @PostMapping("createContact")
    public AddressBookModel createContact(@RequestBody AddressBookDTO addressBookDTO){
        return iAddressBookService.addContacts(addressBookDTO);
    }

    //update
    @PutMapping("update/{id}")
    public AddressBookModel updateContact(@RequestBody AddressBookDTO addressBookDTO,@PathVariable Long id){
        return iAddressBookService.editContact(id,addressBookDTO);
    }

    //retrieve in list
    @GetMapping("getContactList")
    public List<AddressBookModel> getContactList(){
        return iAddressBookService.getContact();
    }

    //delete contact
    @DeleteMapping("deleteContact/{id}")
    public AddressBookModel deleteContact(@PathVariable Long id){
        return iAddressBookService.removeContact(id);
    }

}
