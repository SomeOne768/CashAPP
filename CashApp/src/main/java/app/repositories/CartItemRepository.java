package app.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import app.entities.CartItem;


public interface CartItemRepository extends CrudRepository<CartItem, Long> {
}