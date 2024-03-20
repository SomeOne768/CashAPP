package app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.entities.Cart;
import app.entities.Product;
import app.repositories.ProductRepository;
import app.services.ProductService;
import app.services.ClientService;
import app.services.MyUserDetailsService;
import app.services.CartService;

import org.springframework.ui.Model;

@Controller
public class IndexController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private MyUserDetailsService userDetailService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private CartService cartService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("cart", cartService.getCart());
		return "index";
	}

	@GetMapping(path = { "/secu" })
	public String secu() {

		return "secu.html";
	}

	@PostMapping("/search")
	public ResponseEntity<?> search(@RequestParam(required = false) String searchName) {
		ArrayList<Product> products = productService.findProductsByName(searchName);
		
		// return products;
		if (products.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
		} else {
			return ResponseEntity.ok(products);
		}
	}

}
