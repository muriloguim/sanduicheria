package com.sanduicheria.burguer.management.infrastruture.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sanduicheria.burguer.management.infrastruture.entity.CustomerEntity;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
