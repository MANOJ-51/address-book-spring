package com.bridgelabz.addressbookspring.repository;

import com.bridgelabz.addressbookspring.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAddressBookRepository extends JpaRepository<AddressBookModel,Long> {

    Optional<AddressBookModel> findByEmailId(String emailId);

}
