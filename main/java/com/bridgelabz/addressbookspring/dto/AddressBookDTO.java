package com.bridgelabz.addressbookspring.dto;

import lombok.Data;

@Data
public class AddressBookDTO {
    private Long contactId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private Long zipCode;
    private Long phoneNumber;
    private String emailId;
}
