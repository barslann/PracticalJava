package com.coderman.practicaljava.controller;

import com.coderman.practicaljava.entity.Car;
import com.coderman.practicaljava.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/api/car/v1")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/random",produces = MediaType.APPLICATION_JSON_VALUE)
    public Car random(){
        return carService.createCar();
    }


}
