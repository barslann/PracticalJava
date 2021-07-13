package com.coderman.practicaljava.service.impl;

import com.coderman.practicaljava.entity.Car;
import com.coderman.practicaljava.entity.Engine;
import com.coderman.practicaljava.entity.Tire;
import com.coderman.practicaljava.service.CarService;
import com.coderman.practicaljava.util.RandomDateUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public Car createCar() {
        var brand = BRANDS.get(ThreadLocalRandom.current().nextInt(0,BRANDS.size()));
        var color = COLORS.get(ThreadLocalRandom.current().nextInt(0,COLORS.size()));
        var type = TYPES.get(ThreadLocalRandom.current().nextInt(0,TYPES.size()));
        var available = ThreadLocalRandom.current().nextBoolean();
        var price = ThreadLocalRandom.current().nextInt(5000,12001);
        var firstReleaseDate = RandomDateUtil.generateRandomLocalDate();


        //Additional feature list creation
        var randomCount = ThreadLocalRandom.current().nextInt(ADDITIONAL_FEATURES.size());
        var additionalFeatures = new ArrayList<String>();
        for (int i = 0; i < randomCount; i++) {
            additionalFeatures.add(ADDITIONAL_FEATURES.get(i));
        }

        //Engine creation
        var fuel = FUELS.get(ThreadLocalRandom.current().nextInt(0,FUELS.size()));
        var horsePower =  ThreadLocalRandom.current().nextInt(100,221);
        var engine = new Engine(fuel,horsePower,"Black","SN0001");

        // creation of list of tires
        var tires = new ArrayList<Tire>();
        for (int i = 0; i < 3; i++) {
            var manufacturer = TIRE_MANUFACTURERS.get(ThreadLocalRandom.current().nextInt(0,TIRE_MANUFACTURERS.size()));
            var size = ThreadLocalRandom.current().nextInt(15,18);
            var tirePrice = ThreadLocalRandom.current().nextInt(100,200);
            tires.add(new Tire(manufacturer,size,tirePrice));
        }

        var secretFeature = ThreadLocalRandom.current().nextBoolean() ? "Can fly" : null;

        return new Car("1",brand,color,type,price,available,firstReleaseDate,additionalFeatures,engine,tires,secretFeature);
    }
}
