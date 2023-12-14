package com.example.PizzaParty;

import com.example.PizzaParty.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;
    private Pizza pizza;
    private Drink drink;

    @BeforeEach
    void setUp() {
        order = new Order();
        pizza = new Pizza();
        pizza.setNazwa("Margherita");
        pizza.setSize(30.0);

        drink = new Drink();
        drink.setNazwa("Coca-Cola");
        drink.setCapacity(500.0);

        order.setPizzas(Arrays.asList(pizza));
        order.setDrinks(Arrays.asList(drink));
    }

    @Test
    void pizzas_ShouldBeSetAndReturnedCorrectly() {
        assertEquals(1, order.getPizzas().size());
        assertEquals(pizza, order.getPizzas().get(0));
    }

    @Test
    void drinks_ShouldBeSetAndReturnedCorrectly() {
        assertEquals(1, order.getDrinks().size());
        assertEquals(drink, order.getDrinks().get(0));
    }
}