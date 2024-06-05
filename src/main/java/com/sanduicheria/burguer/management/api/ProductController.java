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
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public @ResponseBody Collection<ProductEntity> listAll() {
        return productService.listAll();
    }

    @GetMapping("{id}")
    public @ResponseBody Optional<ProductEntity> listProductId(@PathVariable String id) {
        return productService.listProduct(id);
        //return ResponseEntity.ok(productService.listProduct(productId));
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDTO> saveProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return ResponseEntity.ok(productService.saveProduct(productRequestDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam ("id") String productId) {
        productService.delete(productId);
        return ResponseEntity.accepted().build();
    }

}
