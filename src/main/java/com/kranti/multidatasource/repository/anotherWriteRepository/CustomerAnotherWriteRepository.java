package com.kranti.multidatasource.repository.anotherWriteRepository;

import org.springframework.data.repository.CrudRepository;

import com.kranti.multidatasource.model.Customer;

public interface CustomerAnotherWriteRepository extends CrudRepository<Customer, Long> {
}
