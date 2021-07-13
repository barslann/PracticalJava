package com.coderman.practicaljava.common;

import com.coderman.practicaljava.entity.Car;
import com.coderman.practicaljava.repo.CarElasticRepository;
import com.coderman.practicaljava.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;


@Component
public class CarElasticDataSource {

    private static final Logger LOG = LoggerFactory.getLogger(CarElasticDataSource.class);

    @Autowired
    private CarElasticRepository carElasticRepository;
    @Autowired
    @Qualifier("carServiceImpl")
    private CarService carService;
    @Autowired
    @Qualifier("webClientElasticsearch")
    private WebClient webClient;

    @EventListener(ApplicationReadyEvent.class)
    public void populateData(){
        var response = webClient.delete().uri("/practical-java").retrieve().bodyToMono(String.class).block();
        LOG.info("End delete with response {}",response);
        
        var cars = new ArrayList<Car>();

        for (int i = 0; i < 100; i++) {
            cars.add(carService.createCar());
        }
        carElasticRepository.saveAll(cars);

        LOG.info("Saved {} cars",carElasticRepository.count());
    }
}
