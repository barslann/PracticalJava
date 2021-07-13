package com.coderman.practicaljava.controller;

import com.coderman.practicaljava.entity.Car;
import com.coderman.practicaljava.service.CarService;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@RestController
@RequestMapping(value = "/api/car/v1")
public class CarController {

    private static final Logger LOG = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @GetMapping(value = "/random",produces = MediaType.APPLICATION_JSON_VALUE)
    public Car random(){
        return carService.createCar();
    }

    @PostMapping(value = "/echo",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String echo(@RequestBody Car car){
        LOG.info("Car is {}",car);
        return car.toString();
    }

    @GetMapping(value = "/random-cars",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> randomCars(){
        var randomCount = ThreadLocalRandom.current().nextInt(1,10);
        var cars = new ArrayList<Car>();

        for (int i = 0; i < randomCount; i++) {
            cars.add(carService.createCar());
        }

        return  cars;
    }

}
