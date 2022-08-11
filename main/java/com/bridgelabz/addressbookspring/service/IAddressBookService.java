package com.bridgelabz.addressbookspring.service;

import com.bridgelabz.addressbookspring.dto.AddressBookDTO;
import com.bridgelabz.addressbookspring.model.AddressBookModel;
import com.bridgelabz.addressbookspring.util.ContactResponse;

import java.util.List;

public interface IAddressBookService  {

    AddressBookModel addContacts(AddressBookDTO addressBookDTO);

    AddressBookModel editContact(String token,Long id, AddressBookDTO addressBookDTO);

    List<AddressBookModel> getContact(String token);

    AddressBookModel removeContact(String token);

    ContactResponse loginContact(String emailId, String password);
}
