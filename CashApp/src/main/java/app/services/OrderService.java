package app.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import app.entities.*;
import org.springframework.stereotype.Service;
import app.repositories.OrderEntityRepository;

@Service
public class OrderService {
    
    @Autowired 
    private OrderEntityRepository orderEntityRepository;

    public void insertOrder(OrderEntity order){
        orderEntityRepository.save(order);
    }

    public List<OrderEntity> findOrdersByClientID(Long clientID) {
        return orderEntityRepository.findByClientId(clientID);
    }

}