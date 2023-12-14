package com.example.PizzaParty.models;

import jakarta.persistence.*;

import java.util.List;

import lombok.Data;

@Data
@Entity
@Table(name = "'Order'")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private List<Pizza> pizzas;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private List<Drink> drinks;

}

