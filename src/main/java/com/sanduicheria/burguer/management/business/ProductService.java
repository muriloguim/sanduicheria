package com.sanduicheria.burguer.management.business;


import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import com.sanduicheria.burguer.management.api.converter.ProductConverter;
import com.sanduicheria.burguer.management.api.converter.ProductMapper;
import com.sanduicheria.burguer.management.api.request.ProductRequestDTO;
import com.sanduicheria.burguer.management.api.response.ProductResponseDTO;
import com.sanduicheria.burguer.management.infrastruture.entity.ProductEntity;
import com.sanduicheria.burguer.management.infrastruture.exceptions.BusinessException;
import com.sanduicheria.burguer.management.infrastruture.repository.ProdutctRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProdutctRepository productRepository;
    private final ProductConverter productConverter;
    private final ProductMapper productMapper;

    public Collection<ProductEntity> listAll() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw new BusinessException("Erro ao listar produtos", e);
        }
    }

    public ProductEntity saveProductDTO(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO) {
        try {
            //notNull(productRequestDTO, "Dados do produto são obrigatórios");
            ProductEntity productEntity = saveProductDTO(productConverter.toProductEntity(productRequestDTO));
            return productMapper.toProductResponseDTO(productEntity);
        } catch (Exception e) {
            throw new BusinessException("Erro ao gravar dados do produto", e);
        }
    }

    @Transactional
    public void delete(String productId) {
        productRepository.deleteById(productId);
    }

}
