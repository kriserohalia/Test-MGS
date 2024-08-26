package com.test_BE_Krise.MGS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test_BE_Krise.MGS.entity.Consumption;
import com.test_BE_Krise.MGS.service.ConsumptionService;

@RestController
@RequestMapping("/consumptions")

public class ConsumptionController {

    @Autowired
    private ConsumptionService consumptionService;


    @GetMapping
    public List<Consumption> getAllConsumptions(){
        return consumptionService.getAllConsumptions();

    }

    @PostMapping
    public Consumption createConsumption(@RequestBody Consumption consumption){
        return consumptionService.createConsumption(consumption);

    }
    
}
