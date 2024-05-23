package com.kranti.multidatasource.repository;

import com.kranti.multidatasource.repository.anotherWriteRepository.CustomerAnotherWriteRepository;
import com.kranti.multidatasource.repository.writeRepository.CustomerWriteRepository;

public interface CustomerRepositoryCombo extends CustomerAnotherWriteRepository, CustomerWriteRepository {

}
