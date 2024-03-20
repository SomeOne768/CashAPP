package app.controllers;


import java.util.*;

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
import app.entities.Client;
import app.entities.OrderEntity;
import app.repositories.ProductRepository;
import app.services.ProductService;
import app.services.ClientService;
import app.services.MyUserDetailsService;
import app.services.CartService;
import app.services.OrderService;

import org.springframework.ui.Model;
import java.util.*;
import org.springframework.web.bind.annotation.*;

import app.entities.Product;
import app.repositories.ProductRepository;
import app.services.ProductService;
import app.services.ClientService;
import app.services.OrderService;
import app.services.MyUserDetailsService;

import org.springframework.ui.Model;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

    @Autowired
	private MyUserDetailsService userDetailService;
  
  @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private MyUserDetailsService userDetailService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

	@GetMapping("/orders")
	public String getOrders(Model model) {
        Client client = userDetailService.getLoggedClient();
        List<OrderEntity> orders = orderService.findOrdersByClientID(client.getClientId());
		model.addAttribute("orders", orders);
		return "orders";
    }
}

    // Afficher le formulaire de retour de produit
    @GetMapping("/product/return")
    public String showReturnForm() {
        return "/product/return";
    }

    // // Traiter le retour de produit
    // @PostMapping("/product/return/{id}")
    // public String processReturn(@PathVariable("id") Long id,
    //         @RequestParam("quantity") int quantity) {
    //     productService.returnProduct(id, quantity);
    //     return "/product/return";
    // }

    @PostMapping("/order/{id}/return")
    public String removefromOrder(@PathVariable("id") Long id, @RequestParam("productId") Long id2,
            @RequestParam("quantity") int quantity) {

        productService.returnProduct(id2, quantity);
        orderService.removeProduct(id, id2, quantity);

        return "redirect:/cart";
    }
}
