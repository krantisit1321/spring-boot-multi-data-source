package com.kranti.multidatasource.service;

import java.util.Optional;

import com.kranti.multidatasource.model.Customer;

public interface CustomerService {

    Optional<Customer> getCustomer(Long id);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer);
}
