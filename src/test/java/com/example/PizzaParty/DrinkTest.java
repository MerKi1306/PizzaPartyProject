package com.example.PizzaParty;

import com.example.PizzaParty.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    private Drink drink;

    @BeforeEach
    void setUp() {
        drink = new Drink();
        drink.setNazwa("Cola");
        drink.setCena(2.0);
        drink.setCapacity(500.0);
    }

    @Test
    void name_ShouldBeSetAndReturnedCorrectly() {
        assertEquals("Cola", drink.getNazwa());
    }

    @Test
    void price_ShouldBeSetAndReturnedCorrectly() {
        assertEquals(2.0, drink.getCena());
    }

    @Test
    void capacity_ShouldBeSetAndReturnedCorrectly() {
        assertEquals(500.0, drink.getCapacity());
    }
}