package com.sanduicheria.burguer.management.infrastruture.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sanduicheria.burguer.management.infrastruture.entity.ProductEntity;

public interface ProdutctRepository extends MongoRepository<ProductEntity, String> {
}
