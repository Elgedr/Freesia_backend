package com.freesia.server.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/freesia")
@RestController
public class ExapleController {

    @GetMapping
    public String hello(){
        return "Hello! We are FREESIA team";
    }
}
