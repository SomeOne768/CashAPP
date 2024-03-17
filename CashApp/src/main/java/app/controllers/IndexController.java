package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.repositories.ProductRepository;

import org.springframework.ui.Model;

@Controller
public class IndexController {

  @Autowired
  private ProductRepository productRepository;

  @GetMapping(path={"/"})
  public String index(Model model) {
    model.addAttribute("searchedProducts", productRepository.findAll());
    return "index"; 
  }

  @GetMapping(path = { "/secu" })
  public String secu() {

    return "secu.html";
  }
}
