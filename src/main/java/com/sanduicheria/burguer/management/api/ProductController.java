package com.sanduicheria.burguer.management.api;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import com.sanduicheria.burguer.management.api.request.ProductRequestDTO;
import com.sanduicheria.burguer.management.api.response.ProductResponseDTO;
import com.sanduicheria.burguer.management.business.ProductService;
import com.sanduicheria.burguer.management.infrastruture.entity.ProductEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public @ResponseBody Collection<ProductEntity> listAll() {
        return productService.listAll();
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDTO> saveProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return ResponseEntity.ok(productService.saveProduct(productRequestDTO));
    }

}
