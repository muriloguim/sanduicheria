package com.sanduicheria.burguer.management.infrastruture.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sanduicheria.burguer.management.infrastruture.entity.ProductEntity;
import java.util.List;

public interface ProdutctRepository extends MongoRepository<ProductEntity, String> {
    List<ProductEntity> findByCategory(String category);
}
