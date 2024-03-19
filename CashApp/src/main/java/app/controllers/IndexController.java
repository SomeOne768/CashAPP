package app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.entities.Product;
import app.repositories.ProductRepository;
import app.services.ProductService;

import org.springframework.ui.Model;

@Controller
public class IndexController {

  @Autowired
  private ProductRepository productRepository;

   @Autowired
    private ProductService productService;

  @GetMapping(path={"/"})
  public String index(Model model) {
    model.addAttribute("searchedProducts", productRepository.findAll());
    return "index"; 
  }

  // Permet de voir tous les produits disponible à l'achat
  @GetMapping(path = { "/index/GetProducts/" })
  public String findProduct(@RequestParam(name = "query", required = false) String query, Model model) {
    ArrayList<Product> products = productService.findProductsByName(query);
      System.out.println("\n\n\n AAAA \n\n\n");

      for (Product product : products) {
        System.out.println(product.getImageUrl() + "\n");
      }
      

      model.addAttribute("searchedProducts", products);
      return "index";
  }

  @GetMapping(path = { "/secu" })
  public String secu() {

    return "secu.html";
  }
}
