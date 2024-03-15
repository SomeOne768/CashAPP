package app.services;

import org.springframework.beans.factory.annotation.Autowired;
import app.entities.*;
import app.repositories.PurchaseRepository;

public class PurchaseService {
    
    @Autowired 
    private PurchaseRepository purchaseRepository;

    public void insertProduct(Purchase purchase){
        purchaseRepository.save(purchase);
    }

}