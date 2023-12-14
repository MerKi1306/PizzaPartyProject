package com.example.PizzaParty.services;

import com.example.PizzaParty.models.Drink;
import com.example.PizzaParty.repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;

    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    public Optional<Drink> getDrinkById(Long id) {
        return drinkRepository.findById(id);
    }

    public Drink saveDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    public Drink updateDrink(Long id, Drink drink) {
        drink.setId(id);
        return drinkRepository.save(drink);
    }

    public void deleteDrink(Long id) {
        drinkRepository.deleteById(id);
    }
}