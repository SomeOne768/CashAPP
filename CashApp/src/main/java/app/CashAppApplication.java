package app;

import app.entities.*;
import app.repositories.*;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import app.repositories.UserRepository;
import app.entities.User;

@SpringBootApplication
public class CashAppApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(
            CashAppApplication.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    public static void main(String[] args) {
        SpringApplication.run(CashAppApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        List<String> list = Arrays.asList(strings);

        if (list.contains("install")) {
            productRepository.save(new Product("Chemise", "chemise.jpeg", "Abidas", 10.32, "Noir"));
            productRepository.save(new Product("fraise", "fraise.jpeg", "FiTounis", 4.14, "Rouge"));
            productRepository.save(new Product("pantalon", "pantalon.jpeg", "Celio", 15.65, "Noir"));
            productRepository.save(new Product("pomme", "pomme.jpeg", "Golden", 1.32, "Verte"));

            User u1 = new User("admin", "admin");
            User u2 = new User("user", "user");
            Client c1 = new Client("admin", "admin", null, 63000);
            Client c2 = new Client("user", "user", null, 01000);
            u1.setClient(c1);
            u1.setClient(c2);
            
            Cart cart1 = new Cart();
            Cart cart2 = new Cart();
            c1.setCart(cart1);
            c2.setCart(cart2);

            cartRepository.save(cart1);
            cartRepository.save(cart2);
            
            clientRepository.save(c1);
            clientRepository.save(c2);

            userRepository.save(u1);
            userRepository.save(u2);
            // userRepository.save(new User("user", "user"));
        }
    }

}
