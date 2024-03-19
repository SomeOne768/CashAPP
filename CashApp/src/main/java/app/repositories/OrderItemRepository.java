package app.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import app.entities.Order;
import app.entities.OrderItem;


public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}