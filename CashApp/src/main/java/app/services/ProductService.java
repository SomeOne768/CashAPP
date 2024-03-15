package app.services;

import org.springframework.beans.factory.annotation.Autowired;
import app.entities.*;
import app.repositories.ProductRepository;

public class ProductService {
    
    @Autowired 
    private ProductRepository productRepository;

    public void insertProduct(Product product){
        productRepository.save(product);
    }

}