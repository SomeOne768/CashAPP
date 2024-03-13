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
public class CashAppApplication {

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

	public void run(String... strings) throws Exception {

		// Order order = new Order(orderRepository.findById(1L).get(), "essai en cours");
		

		List<String> list = Arrays.asList(strings);

		System.out.println("qdkqjsndkj\nooooooo\nuuuuuuuuu\njjjjj\n");
		if (list.contains("install")) {

			// Product product = new Product("teeshirt", "https://url.com", "carrefour", 15.5, "rouge");
			// productRepository.save(product);

			// Client client = new Client("prenom", "nom", new Date(), 63800);
			// clientRepository.save(client);

			// Order order = new Order(client, new Date(), 15.25, "carte");
			// orderRepository.save(order);

			// Purchase purchase = new Purchase(order, product, 6, 6);
			// purchaseRepository.save(purchase);

			// A corriger car probleme lors de la creation des tables

			// jdbcTemplate.execute("DROP TABLE products IF EXISTS");
			// jdbcTemplate.execute(
			// 	"CREATE TABLE products (" +
			// 		"product_id IDENTITY PRIMARY KEY," +
			// 		"name VARCHAR(50) DEFAULT '', " +
			// 		"brand VARCHAR(20) DEFAULT '', " +
			// 		"price FLOAT, " +
			// 		"color VARCHAR(20) DEFAULT ''" +
			// 		");");
		
			// log.info("TABLE products CREATED");
			// jdbcTemplate.execute("DROP TABLE clients IF EXISTS");
			// jdbcTemplate.execute(
			// 	"CREATE TABLE clients (" +
			// 		"client_id IDENTITY PRIMARY KEY," +
			// 		"firstname VARCHAR(50) DEFAULT '', " +
			// 		"lastname VARCHAR(20) DEFAULT '', " +
			// 		"birthdate DATE, " +
			// 		"postcode INTEGER" +
			// 		");");

			// log.info("TABLE clients CREATED");

			// jdbcTemplate.execute("DROP TABLE orders IF EXISTS");
			// jdbcTemplate.execute(
			// 	"CREATE TABLE orders (" +
			// 		"order_id IDENTITY PRIMARY KEY," +
			// 		"client INTEGER NOT NULL, " +
			// 		"purchase_date DATETIME, " +
			// 		"total FLOAT, " +
			// 		"payment_method VARCHAR(20), " +
			// 		"FOREIGN KEY(client) REFERENCES clients(client_id)" +
			// 		");");
		
			// log.info("TABLE purchases CREATED");
			// jdbcTemplate.execute("DROP TABLE purchases IF EXISTS");
			// jdbcTemplate.execute(
			// 	"CREATE TABLE purchases (" +
			// 		"purchase_id IDENTITY PRIMARY KEY," +
			// 		"order_id INTEGER NOT NULL, " +
			// 		"product INTEGER NOT NULL, " +
			// 		"quantity INTEGER, " +
			// 		"unit_price FLOAT," +
			// 		"FOREIGN KEY(order_id) REFERENCES orders(order_id)," +
			// 		"FOREIGN KEY(product) REFERENCES products(product_id)" +
			// 		");"); 

		}

	}
}
