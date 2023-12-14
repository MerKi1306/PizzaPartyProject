package com.example.PizzaParty.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Drink extends Product {
    private double capacity;
}
