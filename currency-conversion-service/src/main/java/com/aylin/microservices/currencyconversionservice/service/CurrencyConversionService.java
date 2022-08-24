package com.aylin.microservices.currencyconversionservice.service;

import com.aylin.microservices.currencyconversionservice.model.CurrencyConversion;
import com.aylin.microservices.currencyconversionservice.repo.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class CurrencyConversionService {

    @Autowired
    CurrencyExchangeProxy proxy;

    public CurrencyConversion calculateCurrencyConversion(String from, String to, BigDecimal quantity){

        String uri = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";

        HashMap<String, String> urlParams = new HashMap<>();
        urlParams.put("from", from);
        urlParams.put("to", to);

        ResponseEntity<CurrencyConversion> result = new RestTemplate().getForEntity(uri, CurrencyConversion.class, urlParams);
        CurrencyConversion currencyConversionResult = result.getBody();

        return  new CurrencyConversion(currencyConversionResult.getId()
                , from
                , to
                , currencyConversionResult.getConversionMultiple()
                , quantity
                ,  quantity.multiply(currencyConversionResult.getConversionMultiple())
                ,currencyConversionResult.getEnvironment());
    }

    public CurrencyConversion calculateCurrencyConversionFeign(String from, String to, BigDecimal quantity){

        CurrencyConversion currencyConversionResult = proxy.getCurrencyExchange(from, to);

        return  new CurrencyConversion(currencyConversionResult.getId()
                , from
                , to
                , currencyConversionResult.getConversionMultiple()
                , quantity
                ,  quantity.multiply(currencyConversionResult.getConversionMultiple())
                ,currencyConversionResult.getEnvironment());
    }
}
