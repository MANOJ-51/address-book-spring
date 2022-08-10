package com.bridgelabz.addressbookspring.service;

import com.bridgelabz.addressbookspring.dto.AddressBookDTO;
import com.bridgelabz.addressbookspring.exception.ContactNotFoundException;
import com.bridgelabz.addressbookspring.model.AddressBookModel;
import com.bridgelabz.addressbookspring.repository.IAddressBookRepository;
import com.bridgelabz.addressbookspring.util.ContactResponse;
import com.bridgelabz.addressbookspring.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AddressBookService implements IAddressBookService {
    @Autowired
    IAddressBookRepository iAddressBookRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Override
    public AddressBookModel addContacts(AddressBookDTO addressBookDTO) {
        AddressBookModel addressBookModel = new AddressBookModel();
        iAddressBookRepository.save(addressBookModel);
        return addressBookModel;
    }

    @Override
    public AddressBookModel editContact(Long id, AddressBookDTO addressBookDTO) {
        Optional<AddressBookModel> isContactPresent = iAddressBookRepository.findById(id);
        if (isContactPresent.isPresent()){
            isContactPresent.get().setFirstName(addressBookDTO.getFirstName());
            isContactPresent.get().setLastName(addressBookDTO.getLastName());
            isContactPresent.get().setCity(addressBookDTO.getCity());
            isContactPresent.get().setAddress(addressBookDTO.getAddress());
            isContactPresent.get().setState(addressBookDTO.getState());
            isContactPresent.get().setZipCode(addressBookDTO.getZipCode());
            isContactPresent.get().setPhoneNumber(addressBookDTO.getPhoneNumber());
            isContactPresent.get().setEmailId(addressBookDTO.getEmailId());
            return isContactPresent.get();
        }
        throw new ContactNotFoundException(400,"Contact Not Found");
    }

    @Override
    public List<AddressBookModel> getContact(String token) {
        Long contactId = tokenUtil.decodeToken(token);
        Optional<AddressBookModel> isContactPresent = iAddressBookRepository.findById(contactId);
        if (isContactPresent.isPresent()) {
            List<AddressBookModel> getList = iAddressBookRepository.findAll();
            if (getList.size() > 0) {
                return getList;
            } else {
                throw new ContactNotFoundException(400, "List Is Empty ");
            }
        }
        throw new ContactNotFoundException(400,"Token is not Correct");
    }
    @Override
    public AddressBookModel removeContact(Long id) {
        Optional<AddressBookModel> isContactPresent = iAddressBookRepository.findById(id);
        if (isContactPresent.isPresent()){
            iAddressBookRepository.delete(isContactPresent.get());
            return isContactPresent.get();
        }else {
            throw new ContactNotFoundException(400,"Contact Not Found");
        }
    }

    @Override
    public ContactResponse loginContact(String emailId, String password) {
        Optional<AddressBookModel> isContactPresent = iAddressBookRepository.findByEmailId(emailId);
        if (isContactPresent.isPresent()){
            if (isContactPresent.get().getPassword().equals(password)){
                return new ContactResponse(200,"Login Successfull",tokenUtil);
            }else {
                throw new ContactNotFoundException(400,"Contact Not Found");
            }
        }
        throw new ContactNotFoundException(400,"no data found");
    }
}
