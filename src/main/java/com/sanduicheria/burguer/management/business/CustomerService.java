package com.sanduicheria.burguer.management.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanduicheria.burguer.management.infrastruture.entity.CustomerEntity;
import com.sanduicheria.burguer.management.infrastruture.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerEntity save(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

}
