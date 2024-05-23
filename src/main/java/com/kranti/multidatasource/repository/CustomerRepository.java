package com.kranti.multidatasource.repository;

import org.springframework.stereotype.Service;

import com.kranti.multidatasource.model.Customer;
import com.kranti.multidatasource.repository.anotherWriteRepository.CustomerAnotherWriteRepository;
import com.kranti.multidatasource.repository.writeRepository.CustomerWriteRepository;

import java.util.Optional;

@Service
public class CustomerRepository implements CustomerRepositoryCombo {

    private final CustomerAnotherWriteRepository anotherWriteRepository;
    private final CustomerWriteRepository writeRepository;

    public CustomerRepository(CustomerAnotherWriteRepository anotherWriteRepository, CustomerWriteRepository customerWriteRepository) {
        this.anotherWriteRepository = anotherWriteRepository;
        this.writeRepository = customerWriteRepository;
    }

    @Override
    public <S extends Customer> S save(S s) {
        anotherWriteRepository.save(s);
        return writeRepository.save(s);
    }

    @Override
    public <S extends Customer> Iterable<S> saveAll(Iterable<S> iterable) {
        return writeRepository.saveAll(iterable);
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        return anotherWriteRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return anotherWriteRepository.existsById(aLong);
    }

    @Override
    public Iterable<Customer> findAll() {
        return writeRepository.findAll();
    }

    @Override
    public Iterable<Customer> findAllById(Iterable<Long> iterable) {
        return anotherWriteRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return anotherWriteRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        anotherWriteRepository.deleteById(aLong);
        writeRepository.deleteById(aLong);
    }

    @Override
    public void delete(Customer customer) {
        anotherWriteRepository.delete(customer);
        writeRepository.delete(customer);
    }

    @Override
    public void deleteAll(Iterable<? extends Customer> iterable) {
        anotherWriteRepository.deleteAll(iterable);
        writeRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        anotherWriteRepository.deleteAll();
        writeRepository.deleteAll();
    }
}
