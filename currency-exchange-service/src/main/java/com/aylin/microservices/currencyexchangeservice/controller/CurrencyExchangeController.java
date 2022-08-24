package com.aylin.microservices.currencyexchangeservice.controller;

import com.aylin.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.aylin.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeService service;

    @RequestMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> getCurrencyExchange(@PathVariable String from, @PathVariable String to){

        CurrencyExchange currencyExchange = service.getCurrencyExchange(from, to);

        if(currencyExchange == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else
            return ResponseEntity.status(HttpStatus.OK).body(currencyExchange);
    }
}
