package app.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import app.entities.*;
import org.springframework.stereotype.Service;
import app.repositories.ProductRepository;

@Service
public class ProductService {
    
	@Autowired
	private ProductRepository productRepository;

	public void insertProduct(Product product){
    	productRepository.save(product);
	}

	public ArrayList<Product> findProductsByName(String name) {
        Iterable<Product> products = productRepository.findAll();
        ArrayList<Product> produitsFiltres = new ArrayList<>();
    
        for (Product product : products) {
            if (product.getName().toUpperCase().contains(name.toUpperCase())) {
                produitsFiltres.add(product);
            }
        }
    
        return produitsFiltres;
    }
}
