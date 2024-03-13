package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

import app.repositories.ProductRepository;
import app.entities.Product;

import java.util.*;

@Controller
public class ShopController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = { "/shop" })
    public String index(Model model) {

        model.addAttribute("products", productRepository.findAll());
        return "shop";
    }

    @GetMapping(path = { "/shop/{id}" })
    public String findProduct(@PathVariable Long id, Model model) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (!productOptional.isPresent())
            return "shop";

        model.addAttribute("product", productOptional.get());
        return "product/index";
    }

    @GetMapping(path = { "/shop/edit/{id}" })
    public String editProduct(@PathVariable Long id, Model model) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (!productOptional.isPresent())
            return "shop";

        model.addAttribute("product", productOptional.get());
        return "product/edit";
    }

    @PostMapping("/product/edit/{id}")
    public String updateProduct(@PathVariable("id") Long productId, @RequestParam String name,
            @RequestParam String brand, @RequestParam Double price,
            @RequestParam String color) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (!productOptional.isPresent()) {
            return "redirect:/shop";
        }

        Product product = productOptional.get();
        product.setName(name);
        product.setBrand(brand);
        product.setPrice(price);
        product.setColor(color);

        productRepository.save(product);

        return "redirect:/shop/" + productId;
    }

    @GetMapping(path = { "/shop/new" })
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/new";
    }

    @PostMapping("/shop/new")
    public String create(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/shop";
    }

}