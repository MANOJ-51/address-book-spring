package com.bridgelabz.addressbookspring.controller;

import com.bridgelabz.addressbookspring.dto.AddressBookDTO;
import com.bridgelabz.addressbookspring.model.AddressBookModel;
import com.bridgelabz.addressbookspring.service.IAddressBookService;
import com.bridgelabz.addressbookspring.util.ContactResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public AddressBookModel createContact( @Valid @RequestBody AddressBookDTO addressBookDTO){
        return iAddressBookService.addContacts(addressBookDTO);
    }

    //update
    @PutMapping("update{id}")
    public AddressBookModel updateContact(@Valid @RequestParam String token,@PathVariable Long id,@RequestBody AddressBookDTO addressBookDTO){
        return iAddressBookService.editContact(token,id,addressBookDTO);
    }

    //retrieve in list
    @GetMapping("getContactList")
    public List<AddressBookModel> getContactList(String token){
        return iAddressBookService.getContact(token);
    }

    //delete contact
    @DeleteMapping("deleteContact")
    public AddressBookModel deleteContact(String token){
        return iAddressBookService.removeContact(token);
    }

    //login
    @PostMapping("loginContact")
    public ContactResponse login (@RequestParam String emailId ,@RequestParam String password){
        return iAddressBookService.loginContact(emailId,password);
    }

    //find by city
    @GetMapping("/findByCity")
    public List<AddressBookModel> findByCity(@RequestParam String city){
        return iAddressBookService.findWithCity(city);
    }

}
