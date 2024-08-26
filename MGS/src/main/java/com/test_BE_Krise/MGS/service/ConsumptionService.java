package com.test_BE_Krise.MGS.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test_BE_Krise.MGS.entity.Consumption;
import com.test_BE_Krise.MGS.repository.ConsumptionRepository;


@Service
public class ConsumptionService {

    @Autowired
    private ConsumptionRepository consumptionRepository;

    public List<Consumption> getAllConsumptions(){
        return consumptionRepository.findAll();
    }

    public Consumption createConsumption(Consumption consumption){
        if (consumption.getCreatedAt() == null) {
            consumption = new Consumption(
                consumption.getId(),
                consumption.getMaxPrice(),
                consumption.getName(),
                OffsetDateTime.now()
            );
        }

        return consumptionRepository.save(consumption);
    }
}
