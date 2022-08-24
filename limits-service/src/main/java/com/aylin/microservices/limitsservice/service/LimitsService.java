package com.aylin.microservices.limitsservice.service;

import com.aylin.microservices.limitsservice.configuration.Configuration;
import com.aylin.microservices.limitsservice.model.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LimitsService {

    @Autowired
    private Configuration config;
    public Limits getLimits(){
        return new Limits(config.getMinimum(), config.getMaximum());
    }
}
