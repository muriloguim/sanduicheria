package com.sanduicheria.burguer.management.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.sanduicheria.burguer.management.business.CustomerService;
import com.sanduicheria.burguer.management.infrastruture.entity.CustomerEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerEntity> saveCustomer(@RequestBody CustomerEntity customer) {
        log.info("AQUIIIIIIIIIIIIIII");
        log.info("Received request to create customer: {}", customer);
        
        CustomerEntity savedCliente = customerService.save(customer);
        return ResponseEntity.ok(savedCliente);
    }

}
