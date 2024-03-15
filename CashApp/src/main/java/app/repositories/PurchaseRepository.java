package app.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import app.entities.Purchase;


public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}