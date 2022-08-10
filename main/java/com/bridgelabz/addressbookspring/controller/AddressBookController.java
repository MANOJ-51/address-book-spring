package com.bridgelabz.addressbookspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {
    @GetMapping("/welcome")
    public String welcomeMessage(){
        return "Welcome to Address Book Spring application";
    }
}
