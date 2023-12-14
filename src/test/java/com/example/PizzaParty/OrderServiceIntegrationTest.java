package com.example.PizzaParty;

import com.example.PizzaParty.models.Order;
import com.example.PizzaParty.repositories.OrderRepository;
import com.example.PizzaParty.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrderServiceIntegrationTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository.deleteAll();
    }

    @Test
    public void whenCreateOrder_thenOrderIsSaved() {
        Order order = new Order();
        Order savedOrder = orderService.saveOrder(order);

        assertNotNull(savedOrder.getId());
        assertTrue(orderRepository.findById(savedOrder.getId()).isPresent());
    }

    @Test
    public void whenGetAllOrders_thenRetrieveOrders() {
        Order order1 = new Order();
        Order order2 = new Order();
        orderService.saveOrder(order1);
        orderService.saveOrder(order2);

        List<Order> orders = orderService.getAllOrders();
        assertTrue(orders.size() >= 2);
    }
}