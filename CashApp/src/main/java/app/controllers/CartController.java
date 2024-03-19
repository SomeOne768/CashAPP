package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;

import app.repositories.ProductRepository;
import app.services.CartService;
import app.services.MyUserDetailsService;
import app.services.ProductService;
import app.entities.Product;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

import java.nio.file.Path;
import java.nio.file.Files;
import app.entities.*;

@Controller
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    ProductRepository productRepository;

    @GetMapping(path = { "/cart" })
    public String index(Model model)
    {
        Cart cart = cartService.getCart();
        Iterable<Product> I = productRepository.findAll();
        for(Product p : I)
        {
            cartService.addToCart(cart, p, 1);
        }
        model.addAttribute("cart", cartService.getCart());
        return "cart/index";
    }

}
