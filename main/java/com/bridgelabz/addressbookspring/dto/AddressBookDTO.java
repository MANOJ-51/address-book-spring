package com.bridgelabz.addressbookspring.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddressBookDTO {
    private Long contactId;
    @NotNull(message = "FirstName should not be null")
    @Pattern(regexp = "[A-Z][a-z]{2,}",message = "First letter should be capital")
    private String firstName;
    @NotNull(message = "LastName should not be null")
    @Pattern(regexp = "[A-Z][a-z]{2,}",message = "First letter should be capital")
    private String lastName;
    @NotNull(message = "address should not be null")
    private String address;
    @NotNull(message = "city should not be null")
    private String city;
    @NotNull(message = "State should not be null")
    private String state;
    @NotNull(message = "zip code should not be null")
    private Long zipCode;
    @NotNull(message = "LastName should not be null")
    private Long phoneNumber;
    @NotNull(message = "Email should not be null")
    @Pattern(regexp = "[\\w+-]+(\\.[\\w+-]+)*@[\\w]+(\\.[\\w]+)?(?=(\\.[A-Za-z_]{2,3}$|\\.[a-zA-Z]{2,3}$)).*",message = "email regex")
    private String emailId;
    @NotNull(message = "password should not be null")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W])(?=.*[a-z]).{8,}$",message = "password regex")
    private String password;
}
