package com.test_BE_Krise.MGS.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "consumption")
@JsonPropertyOrder({"createdAt","name","maxPrice","id"})
public class Consumption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name= "maxPrice", nullable = false)
    private Long maxPrice;
    private String name;
    private OffsetDateTime createdAt;

    public Consumption() {
    }

    public Consumption(Long id, Long maxPrice, String name, OffsetDateTime createdAt) {
        this.id = id;
        this.maxPrice = maxPrice;
        this.name = name;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Long maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
