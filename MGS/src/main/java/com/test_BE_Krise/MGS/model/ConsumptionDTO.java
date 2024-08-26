package com.test_BE_Krise.MGS.model;

public class ConsumptionDTO {
    private String name;

    public ConsumptionDTO(String name) {
        this.name = name;

    }

    public String getName(){
        return name;
    }

    public void setName(String Name){
        this.name = name;
    }
}
