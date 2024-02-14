package Cashapp;

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
public class CashappApplication implements CommandLineRunner {

	@Autowired
  	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(CashappApplication.class, args);
	}

	@Override
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
		
		log.info("TABLE products CREATED");
		
		jdbcTemplate.execute(
			"CREATE TABLE clients (" +
				"client_id IDENTITY PRIMARY KEY," +
				"firstname VARCHAR(50) DEFAULT '', " +
				"lastname VARCHAR(20) DEFAULT '', " +
				"birthdate DATE, " +
				"postcode INTEGER" +
				");");

		log.info("TABLE clients CREATED");

		jdbcTemplate.execute(
			"CREATE TABLE orders (" +
				"order_id IDENTITY PRIMARY KEY," +
				"client_id INTEGER NOT NULL, " +
				"purchase_date DATETIME, " +
				"total FLOAT, " +
				"payment_method VARCHAR(20), " +
				"FOREIGN KEY(client_id) REFERENCES clients(client_id)" +
				");");

		}
	}
}
