package com.example.PizzaParty.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nazwa;
    private Double cena;
}
