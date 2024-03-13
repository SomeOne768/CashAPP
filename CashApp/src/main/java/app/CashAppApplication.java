package app;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import java.util.Date;

import app.entities.*;
import app.repositories.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CashAppApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(CashAppApplication.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PurchaseRepository purchaseRepository;

	public static void main(String[] args) {
		SpringApplication.run(CashAppApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		List<String> list = Arrays.asList(strings);

		if (list.contains("install")) {
			Product p = new Product("Chemin", "chemise.jpeg", "Abidas", 10.32, "Rouge");
			productRepository.save(p);	
		}

	}
}
