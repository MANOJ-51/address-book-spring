package com.bridgelabz.addressbookspring.repository;

import com.bridgelabz.addressbookspring.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressBookRepository extends JpaRepository<AddressBookModel,Long> {
}
