package com.coderman.practicaljava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"color","serialNumber"})
public class Engine {
    private String fuelType;
    private int horsePower;
    private  String color;
    private  String serialNumber;

}
