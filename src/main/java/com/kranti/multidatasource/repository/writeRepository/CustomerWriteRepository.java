package com.kranti.multidatasource.repository.writeRepository;

import org.springframework.data.repository.CrudRepository;

import com.kranti.multidatasource.model.Customer;

public interface CustomerWriteRepository extends CrudRepository<Customer, Long> {
}
