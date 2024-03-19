package app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import app.entities.Cart;
import app.entities.CartItem;
import app.entities.Client;
import app.entities.Product;
import app.repositories.CartItemRepository;
import app.repositories.CartRepository;
import app.repositories.ClientRepository;
import app.repositories.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CartService {
    

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CartItemRepository cartItemRepository;
    
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @PersistenceContext
    EntityManager entityManager;

    public Cart getCart()
    {
        Client c = myUserDetailsService.getClient();
        return c.getCart();

    }

    public void addToCart(Cart cart, Product product, int quantity)
    {
        
        for(CartItem item: cart.getItems())
        {
            if(item.getProduct() == product)
            {
                item.setQuantity(quantity+item.getQuantity());
                return;
            }
        }

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(quantity);

        // cartItemRepository.save(item);
        // cartRepository.save(cart);

        entityManager.persist(item);
        entityManager.persist(cart);
        entityManager.flush();
    }
}
