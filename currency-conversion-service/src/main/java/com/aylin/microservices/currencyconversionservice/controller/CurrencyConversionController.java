package com.aylin.microservices.currencyconversionservice.controller;

import com.aylin.microservices.currencyconversionservice.model.CurrencyConversion;
import com.aylin.microservices.currencyconversionservice.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyConversionService service;

    @RequestMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConversion> calculateCurrencyConversion(@PathVariable String from
                                                                        , @PathVariable String to
                                                                        , @PathVariable BigDecimal quantity){

        CurrencyConversion currencyConversion = service.calculateCurrencyConversionFeign(from, to, quantity);
        if(currencyConversion == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else
            return ResponseEntity.status(HttpStatus.OK).body(currencyConversion);

    }
}
