package app.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import app.entities.Order;


public interface OrderRepository extends CrudRepository<Order, Long> {
}