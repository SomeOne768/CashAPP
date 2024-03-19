package app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.entities.Product;
import app.repositories.ProductRepository;
import app.services.ProductService;
import app.services.ClientService;
import org.springframework.ui.Model;

@Controller
public class IndexController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private ClientService clientService;

	@GetMapping("/")
	public String index(@RequestParam(required = false, defaultValue = "user") String username, @RequestParam(required = false, defaultValue = "") String productName, Model model) {

        model.addAttribute("client", clientService.findByFirstname(username));
		model.addAttribute("searchedProducts", productService.findProductsByName(productName));
        return "index"; // Nom de la vue Thymeleaf à afficher
    }

	@GetMapping(path = { "/secu" })
	public String secu() {

		return "secu.html";
	}
}
