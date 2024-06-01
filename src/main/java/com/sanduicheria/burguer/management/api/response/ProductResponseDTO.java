package com.sanduicheria.burguer.management.api.response;

public record ProductResponseDTO(String id,
                                 String name,
                                 String price,
                                 String description,
                                 String category) {

}
