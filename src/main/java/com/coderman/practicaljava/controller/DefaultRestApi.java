package com.coderman.practicaljava.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping(value = "/api")
public class DefaultRestApi {

    @GetMapping (value = "/welcome")
    public String welcome(){
        return "hey";
    }

    @GetMapping("time")
    public String time(){
        return LocalTime.now().toString();
    }

}
