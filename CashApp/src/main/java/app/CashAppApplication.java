package app;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CashAppApplication {

	// private static final Logger log = LoggerFactory.getLogger(CashAppApplication.class);


	@Autowired
  	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(CashAppApplication.class, args);
	}

	public void run(String... strings) throws Exception {

		// Task task = new Task(categoryRepository.findById(1L).get(), "essai en cours");
		// taskRepository.save(task);

		List<String> list = Arrays.asList(strings);
		if (list.contains("install")) {


		// A corriger car probleme lors de la creation des tables

		jdbcTemplate.execute("DROP TABLE products IF EXISTS");
		jdbcTemplate.execute(
			"CREATE TABLE products (" +
				"product_id IDENTITY PRIMARY KEY," +
				"name VARCHAR(50) DEFAULT '', " +
				"brand VARCHAR(20) DEFAULT '', " +
				"price FLOAT, " +
				"color VARCHAR(20) DEFAULT ''" +
				");");
		
		// log.info("TABLE products CREATED");
		jdbcTemplate.execute("DROP TABLE clients IF EXISTS");
		jdbcTemplate.execute(
			"CREATE TABLE clients (" +
				"client_id IDENTITY PRIMARY KEY," +
				"firstname VARCHAR(50) DEFAULT '', " +
				"lastname VARCHAR(20) DEFAULT '', " +
				"birthdate DATE, " +
				"postcode INTEGER" +
				");");

		// log.info("TABLE clients CREATED");

		jdbcTemplate.execute("DROP TABLE orders IF EXISTS");
		jdbcTemplate.execute(
			"CREATE TABLE orders (" +
				"order_id IDENTITY PRIMARY KEY," +
				"client INTEGER NOT NULL, " +
				"purchase_date DATETIME, " +
				"total FLOAT, " +
				"payment_method VARCHAR(20), " +
				"FOREIGN KEY(client) REFERENCES clients(client_id)" +
				");");
		
		// log.info("TABLE clients CREATED");
		jdbcTemplate.execute("DROP TABLE purchases IF EXISTS");
		jdbcTemplate.execute(
			"CREATE TABLE purchases (" +
				"purchase_id IDENTITY PRIMARY KEY," +
				"order INTEGER NOT NULL, " +
				"product INTEGER NOT NULL, " +
				"quantity INTEGER, " +
				"unit_price FLOAT, " +
				"FOREIGN KEY(order) REFERENCES orders(order_id)" +
				"FOREIGN KEY(product) REFERENCES products(product_id)" +
				");"); 

		}

	}
}
