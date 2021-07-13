package com.coderman.practicaljava.service;

import com.coderman.practicaljava.entity.Car;

import java.util.List;

public interface CarService {

    List<String> BRANDS = List.of("Toyota","Honda","Ford","BMW","MERCEDES");
    List<String> COLORS = List.of("Red","Black","White","Pink","GREY");
    List<String> TYPES = List.of("Sedan","SUV","MPV","Hatchback","Convertible");
    List<String> ADDITIONAL_FEATURES = List.of("GPS","ALARM","SUNROOF","MEDIA PLAYER","Leather seats");
    List<String> FUELS = List.of("Petrol","Electric","Hybrid");
    List<String> TIRE_MANUFACTURERS = List.of("Goodyear","Bridgestone","Dunlop");


    Car createCar();
}
