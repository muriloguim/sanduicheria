package com.sanduicheria.burguer.management.infrastruture.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty(required = true)
    private String document;

}
