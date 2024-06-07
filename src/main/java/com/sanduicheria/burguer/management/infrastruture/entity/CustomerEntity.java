package com.sanduicheria.burguer.management.infrastruture.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Document(collection = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntity {

    @Id
    private String id;
    private String name;
    private String cellphone;

    @NotBlank(message = "CPF é um campo obrigatório")
    private String document;

}
