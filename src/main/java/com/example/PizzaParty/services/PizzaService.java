package com.example.PizzaParty.services;

import com.example.PizzaParty.models.Pizza;
import com.example.PizzaParty.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> getPizzaById(Long id) {
        return pizzaRepository.findById(id);
    }

    public Pizza savePizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Pizza updatePizza(Long id, Pizza pizza) {
        pizza.setId(id);
        return pizzaRepository.save(pizza);
    }

    public void deletePizza(Long id) {
        pizzaRepository.deleteById(id);
    }
}
