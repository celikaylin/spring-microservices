package com.aylin.microservices.currencyexchangeservice.service;

import com.aylin.microservices.currencyexchangeservice.model.Currency;
import com.aylin.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.aylin.microservices.currencyexchangeservice.repo.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyExchangeService {

    @Autowired
    private Environment environment;
    @Autowired
    private CurrencyExchangeRepository repository;
    public CurrencyExchange getCurrencyExchange(String from, String to){

        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
        if(currencyExchange != null)
            currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
       return currencyExchange;
    }
}
