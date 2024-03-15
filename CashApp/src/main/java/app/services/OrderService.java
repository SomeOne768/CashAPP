package app.services;

import org.springframework.beans.factory.annotation.Autowired;
import app.entities.*;
import app.repositories.OrderRepository;

public class OrderService {
    
    @Autowired 
    private OrderRepository orderRepository;

    public void insertOrder(Order order){
        orderRepository.save(order);
    }

}