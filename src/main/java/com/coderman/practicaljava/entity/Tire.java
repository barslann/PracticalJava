package com.coderman.practicaljava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tire {
    private String manufacturer;
    @JsonProperty(value = "diameter")
    private int size;

    @JsonIgnore
    private int price;
}
