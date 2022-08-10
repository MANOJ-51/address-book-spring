package com.bridgelabz.addressbookspring.service;

import com.bridgelabz.addressbookspring.dto.AddressBookDTO;
import com.bridgelabz.addressbookspring.model.AddressBookModel;

import java.util.List;

public interface IAddressBookService  {

    AddressBookModel addContacts(AddressBookDTO addressBookDTO);

    AddressBookModel editContact(Long id, AddressBookDTO addressBookDTO);

    List<AddressBookModel> getContact();

    AddressBookModel removeContact(Long id);
}
