package com.sanduicheria.burguer.management.api.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sanduicheria.burguer.management.api.response.ProductResponseDTO;
import com.sanduicheria.burguer.management.infrastruture.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", source = "product.id")
    @Mapping(target = "name", source = "product.name")
    @Mapping(target = "price", source = "product.price")
    @Mapping(target = "description", source = "product.description")
    @Mapping(target = "category", source = "product.category")
    ProductResponseDTO toProductResponseDTO(ProductEntity product);

}
