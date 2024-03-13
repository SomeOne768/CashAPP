package app.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import app.entities.Client;


public interface ClientRepository extends CrudRepository<Client, Long> {
}