package com.sanduicheria.burguer.management.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ProductRequestDTO {

    @JsonProperty(required = true)
    private String name;

    private String price;

    private String description;

    @JsonProperty(required = true)
    private String category;

}
