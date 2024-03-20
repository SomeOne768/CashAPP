package app.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import app.entities.*;
import org.springframework.stereotype.Service;
import app.repositories.OrderEntityRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import app.entities.*;
import app.repositories.OrderEntityRepository;
import app.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
  
  @Autowired
    private OrderEntityRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public void insertOrder(OrderEntity order) {
        orderRepository.save(order);
    }

    @Transactional
    public void removeProduct(Long OrderId, Long productId, int quantity) {
        Optional<Product> product = productRepository.findById(productId);
        Optional<OrderEntity> order = orderRepository.findById(OrderId);
        if (product.isPresent() && order.isPresent()) {
            for (OrderItem item : order.get().getItems()) {
                if (!product.isPresent() || item.getQuantity() > quantity) {
                    product.get().setQuantity(item.getQuantity() - quantity);
                }
            }
        }
    }

}

