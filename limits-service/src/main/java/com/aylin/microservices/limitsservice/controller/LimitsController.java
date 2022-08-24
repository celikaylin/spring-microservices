package com.aylin.microservices.limitsservice.controller;

import com.aylin.microservices.limitsservice.model.Limits;
import com.aylin.microservices.limitsservice.service.LimitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private LimitsService service;

    @RequestMapping("/limits")
    public Limits getLimits(){

        return service.getLimits();


    }
}
