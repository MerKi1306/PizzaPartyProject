package com.example.PizzaParty.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Pizza extends Product {
    private double size;
}
