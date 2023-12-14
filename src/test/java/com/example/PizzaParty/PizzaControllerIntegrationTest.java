package com.example.PizzaParty;

import com.example.PizzaParty.models.Pizza;
import com.example.PizzaParty.repositories.PizzaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PizzaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PizzaRepository pizzaRepository;

    private Pizza pizza;

    @BeforeEach
    void setUp() {
        pizzaRepository.deleteAll();
        pizza = new Pizza();
        pizza.setNazwa("Margherita");
        pizza.setSize(30.0);
        pizza = pizzaRepository.save(pizza);
    }

    @Test
    public void whenGetAllPizzas_thenReturnsPizzas() throws Exception {
        mockMvc.perform(get("/pizzas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
                .andExpect(jsonPath("$[0].id", is(pizza.getId().intValue())))
                .andExpect(jsonPath("$[0].name", is(pizza.getNazwa())));
    }

    @Test
    public void whenGetPizzaById_thenReturnsPizza() throws Exception {
        mockMvc.perform(get("/pizzas/{id}", pizza.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(pizza.getId().intValue())))
                .andExpect(jsonPath("$.name", is(pizza.getNazwa())));
    }

    @Test
    public void whenPostPizza_thenCreatePizza() throws Exception {
        Pizza newPizza = new Pizza();
        newPizza.setNazwa("Hawaiian");
        newPizza.setSize(32.0);

        mockMvc.perform(post("/pizzas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newPizza)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(newPizza.getNazwa())));
    }

    @Test
    public void whenUpdatePizza_thenPizzaIsUpdated() throws Exception {
        pizza.setNazwa("Pepperoni");

        mockMvc.perform(put("/pizzas/{id}", pizza.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pizza)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Pepperoni")));
    }

    @Test
    public void whenDeletePizza_thenPizzaIsDeleted() throws Exception {
        mockMvc.perform(delete("/pizzas/{id}", pizza.getId()))
                .andExpect(status().isOk());
        mockMvc.perform(get("/pizzas/{id}", pizza.getId()))
                .andExpect(status().isNotFound());
    }
}