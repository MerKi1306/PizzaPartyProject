package com.example.PizzaParty;

import com.example.PizzaParty.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    private Pizza pizza;

    @BeforeEach
    void setUp() {
        pizza = new Pizza();
        pizza.setNazwa("Pepperoni");
        pizza.setCena(20.0);
        pizza.setSize(30.0);
    }

    @Test
    void name_ShouldBeSetAndReturnedCorrectly() {
        assertEquals("Pepperoni", pizza.getNazwa());
    }

    @Test
    void price_ShouldBeSetAndReturnedCorrectly() {
        assertEquals(20.0, pizza.getCena());
    }

    @Test
    void size_ShouldBeSetAndReturnedCorrectly() {
        assertEquals(30.0, pizza.getSize());
    }
}