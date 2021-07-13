package com.coderman.practicaljava.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.lang.annotation.Documented;
import java.time.LocalDate;
import java.util.List;

@Document(indexName = "practical-java")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Car {
    @Id
    private String id;
    private String brand;
    private String color;
    private String type;
    private int price;
    private boolean available;
    @Field(type = FieldType.Date,format = DateFormat.date) //elastic search mapping date to elastic search date
    @JsonFormat(pattern = "YYYY-MM-dd",timezone = "Los Angeles")
    private LocalDate firstReleaseDate;
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private List<String> additionalFeatures;
    @JsonUnwrapped
    private Engine engine;
    private List<Tire> tires;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String secretFeature;

}
