package com.sanduicheria.burguer.management.api;

import java.util.Collection;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import com.sanduicheria.burguer.management.api.request.ProductRequestDTO;
import com.sanduicheria.burguer.management.api.response.ProductResponseDTO;
import com.sanduicheria.burguer.management.business.ProductService;
import com.sanduicheria.burguer.management.infrastruture.entity.ProductEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@Controller
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public @ResponseBody Collection<ProductEntity> listAllProducts() {
        return productService.listAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<ProductEntity> listProductId(@PathVariable String id) {
        return productService.listProduct(id);
        //return ResponseEntity.ok(productService.listProduct(productId));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<Collection<ProductEntity>> getProductsByCategory(@PathVariable String category) {
        Collection<ProductEntity> products = productService.findByCategory(category);
        if(products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDTO> saveProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return ResponseEntity.ok(productService.saveProduct(productRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable String id, @RequestBody ProductEntity productDetails) {
        Optional<ProductEntity> optionalProduct = productService.listProduct(id);        
        if (!optionalProduct.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        ProductEntity product = optionalProduct.get();
        product.setName(productDetails.getName());
        product.setCategory(productDetails.getCategory());
        product.setDescription(productDetails.getDescription());
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());

        ProductEntity updateProduct = productService.saveProductDTO(product);
        return ResponseEntity.ok(updateProduct);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductEntity> update(@PathVariable String id, @RequestBody ProductEntity productDetails) {
        Optional<ProductEntity> optionalProduct = productService.listProduct(id);        
        if (!optionalProduct.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        ProductEntity product = optionalProduct.get();

        if (productDetails.getName() != null) {
            product.setName(productDetails.getName());
        }
        if (productDetails.getCategory() != null) {
            product.setCategory(productDetails.getCategory());
        }
        if (productDetails.getDescription() != null) {
            product.setDescription(productDetails.getDescription());
        }
        if (productDetails.getName() != null) {
            product.setName(productDetails.getName());
        }
        if (productDetails.getPrice() != null) {
            product.setPrice(productDetails.getPrice());
        }
        
        ProductEntity updateProduct = productService.saveProductDTO(product);
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam ("id") String productId) {
        productService.delete(productId);
        return ResponseEntity.accepted().build();
    }    

}
