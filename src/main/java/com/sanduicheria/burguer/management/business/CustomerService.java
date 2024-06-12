package com.sanduicheria.burguer.management.business;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sanduicheria.burguer.management.infrastruture.entity.CustomerEntity;
import com.sanduicheria.burguer.management.infrastruture.exceptions.BusinessException;
import com.sanduicheria.burguer.management.infrastruture.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Collection<CustomerEntity> listAll() {
        try {
            return customerRepository.findAll();
        } catch (Exception e) {
            throw new BusinessException("Erro ao listar clientes", e);
        }
    }

    public Optional<CustomerEntity> listCustomer(String customerId) {
        try {
            return customerRepository.findById(customerId);
        } catch (Exception e) {
            throw new BusinessException("Erro ao listar informações do cliente", e);
        }
    }

    public CustomerEntity save(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

}
