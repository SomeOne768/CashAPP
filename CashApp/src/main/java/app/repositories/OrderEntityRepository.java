package app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import app.entities.OrderEntity;
import app.entities.Product;

public interface OrderEntityRepository extends CrudRepository<OrderEntity, Long> {
    public List<OrderEntity> findByClientId(Long clientId);
}