package app.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import app.entities.Product;


public interface ProductRepository extends CrudRepository<Product, Long> {
}