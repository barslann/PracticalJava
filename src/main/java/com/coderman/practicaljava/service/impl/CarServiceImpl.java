package com.coderman.practicaljava.service.impl;

import com.coderman.practicaljava.entity.Car;
import com.coderman.practicaljava.service.CarService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public Car createCar() {
        var brand = BRANDS.get(ThreadLocalRandom.current().nextInt(0,BRANDS.size()));
        var color = COLORS.get(ThreadLocalRandom.current().nextInt(0,COLORS.size()));
        var type = TYPES.get(ThreadLocalRandom.current().nextInt(0,TYPES.size()));

        return new Car(brand,color,type);
    }
}
