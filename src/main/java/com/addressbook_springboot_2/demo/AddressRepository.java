package com.addressbook_springboot_2.demo;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

 //   Iterable<Address> findAllByFirstNameOrLastNameOrEmailOrAddressInfoOrPhoneNumber(String search);

    Iterable<Address> findAllByFirstName(String search);
//    Iterable<Address> findAllByLastName(String search);
//    Iterable<Address> findAllByEmail(String search);
//    Iterable<Address> findAllByAddressInfo(String search);
//    Iterable<Address> findAllByPhoneNumber(String search);


}