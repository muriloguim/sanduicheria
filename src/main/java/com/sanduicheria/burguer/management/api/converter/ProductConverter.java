package com.sanduicheria.burguer.management.api.converter;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.sanduicheria.burguer.management.api.request.ProductRequestDTO;
import com.sanduicheria.burguer.management.infrastruture.entity.ProductEntity;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductConverter {

    public ProductEntity toProductEntity(ProductRequestDTO productDTO) {
        return ProductEntity.builder()
                .id(UUID.randomUUID().toString())
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .category(productDTO.getCategory())
                .build();
    }
}
