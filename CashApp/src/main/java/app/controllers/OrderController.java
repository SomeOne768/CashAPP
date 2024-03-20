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

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

    @Autowired
	private MyUserDetailsService userDetailService;

	@GetMapping("/orders")
	public String getOrders(Model model) {
        Client client = userDetailService.getLoggedClient();
        List<OrderEntity> orders = orderService.findOrdersByClientID(client.getClientId());
		model.addAttribute("orders", orders);
		return "orders";
    }
}
