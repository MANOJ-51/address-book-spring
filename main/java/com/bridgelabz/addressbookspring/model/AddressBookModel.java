package com.bridgelabz.addressbookspring.model;

import com.bridgelabz.addressbookspring.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "contact_details")
public class AddressBookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contactId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private Long zipCode;
    private Long phoneNumber;
    private String emailId;
    private  String password;

    public AddressBookModel(AddressBookDTO addressBookDTO){
        this.contactId = addressBookDTO.getContactId();
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.zipCode = addressBookDTO.getZipCode();
        this.phoneNumber =addressBookDTO.getPhoneNumber();
        this.emailId=addressBookDTO.getEmailId();
        this.password=addressBookDTO.getPassword();
    }

    public AddressBookModel() {
    }
}
