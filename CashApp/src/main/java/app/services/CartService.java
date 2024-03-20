package app.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import app.entities.Cart;
import app.entities.CartItem;
import app.entities.Client;
import app.entities.OrderEntity;
import app.entities.OrderItem;
import app.entities.Product;
import app.repositories.CartItemRepository;
import app.repositories.CartRepository;
import app.repositories.ClientRepository;
import app.repositories.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @PersistenceContext
    EntityManager entityManager;

    public Cart getCart() {
        Client c = myUserDetailsService.getLoggedClient();
        return c.getCart();
    }

    @Transactional
    public void addToCart(Cart cart, Product product, int quantity) {
        quantity = (product.getQuantity() < quantity) ? product.getQuantity() : quantity;
        for (CartItem item : cart.getItems()) {
            if (item.getProduct() == product) {
                item.setQuantity(quantity + item.getQuantity());
                return;
            }
        }

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(quantity);
        cart.addItems(item);

        product.setQuantity(product.getQuantity() - quantity);
        entityManager.persist(item);
        entityManager.persist(cart);
        entityManager.persist(product);
        entityManager.flush();
    }

    @Transactional
    public void deleteFromCart(Cart cart, Product product, int quantity) {
        for (CartItem item : cart.getItems()) {
            if (item.getProduct() == product) {
                quantity = (item.getQuantity() < quantity) ? item.getQuantity() : quantity;
                item.setQuantity(quantity + item.getQuantity());
                product.setQuantity(product.getQuantity() + quantity);

                if (item.getQuantity() == 0) {
                    // retirer du panier
                    cart.removeItems(item);
                    entityManager.remove(item);
                } else {
                    entityManager.persist(item);
                }

                entityManager.persist(cart);
                entityManager.persist(product);
                entityManager.flush();
                return;
            }
        }
    }

    @Transactional
    public void paye(Cart cart) {
        if (cart.getItems() == null || cart.getItems().isEmpty())
            return;

        OrderEntity order = new OrderEntity();
        Client c = myUserDetailsService.getLoggedClient();
        order.setPurchaseDate(new Date());
        order.setClientId(c.getClientId());
        order.setPaymentMethod("CB");

        double total = 0;

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            OrderItem orderItem = new OrderItem(order, product.getName(), item.getQuantity(), product.getPrice());

            total += item.getQuantity() * product.getPrice();

            order.addItems(orderItem);
            entityManager.persist(orderItem);
            entityManager.remove(item);
        }

        cart.clearList();

        order.setTotal(total);
        entityManager.persist(order);
        entityManager.persist(cart);
        entityManager.flush();
    }

}
