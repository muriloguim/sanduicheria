package com.sanduicheria.burguer.management.api;

import java.util.Collection;
import java.util.Optional;

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

    @GetMapping()
    public @ResponseBody Collection<CustomerEntity> listAllCustomers() {
        return customerService.listAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<CustomerEntity> listProductId(@PathVariable String id) {
        return customerService.listCustomer(id);
    }

    @GetMapping("/document/{document}")
    public ResponseEntity<Collection<CustomerEntity>> getCustomerByDocument(@PathVariable String document) {
        Collection<CustomerEntity> customer = customerService.findByDocument(document);
        if(customer.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<CustomerEntity> saveCustomer(@RequestBody CustomerEntity customer) {
        log.info("AQUIIIIIIIIIIIIIII");
        
        CustomerEntity savedCliente = customerService.save(customer);
        return ResponseEntity.ok(savedCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerEntity> updateProduct(@PathVariable String id, @RequestBody CustomerEntity customerDetails) {
        Optional<CustomerEntity> optionalCustomer = customerService.listCustomer(id);        
        if (!optionalCustomer.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        CustomerEntity customer = optionalCustomer.get();
        customer.setName(customerDetails.getName());
        customer.setCellphone(customerDetails.getCellphone());
        customer.setDocument(customerDetails.getDocument());

        CustomerEntity updateCustomer = customerService.save(customer);
        return ResponseEntity.ok(updateCustomer);
    }

}
