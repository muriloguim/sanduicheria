package com.sanduicheria.burguer.management.business;


import org.springframework.stereotype.Service;
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

}
