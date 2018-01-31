package com.addressbook_springboot_2.demo;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

    Iterable<Address> findAllBy(String search);
}

//findAllByTitleContainingIgnoreCase