package com.example.PizzaParty.services;

import com.example.PizzaParty.models.Order;
import com.example.PizzaParty.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setPizzas(orderDetails.getPizzas());
                    order.setDrinks(orderDetails.getDrinks());
                    return orderRepository.save(order);
                }).orElseGet(() -> {
                    orderDetails.setId(id);
                    return orderRepository.save(orderDetails);
                });
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}