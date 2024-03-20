package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import app.repositories.ProductRepository;
import app.services.CartService;
import app.services.MyUserDetailsService;
import app.services.ProductService;

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
    public String index(Model model) {
        model.addAttribute("cart", cartService.getCart());
        return "cart/index";
    }

    @PostMapping("/cart/add/{id}")
    public ResponseEntity<String> increase(@PathVariable("id") Long id) {
        Cart cart = cartService.getCart();
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            cartService.addToCart(cart, product.get(), 1);
            return ResponseEntity.ok("Product added to cart successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
    }

    @PostMapping("/cart/add/{id}/quantity")
    public ResponseEntity<String> add(@PathVariable("id") Long id, @RequestParam("quantity") int quantity) {
        Cart cart = cartService.getCart();
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent() || quantity < 1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        } else {
            cartService.addToCart(cart, product.get(), quantity);
            return ResponseEntity.ok("Product added to cart successfully.");
        }
    }

}
