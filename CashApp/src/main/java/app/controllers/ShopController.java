package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

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
}
