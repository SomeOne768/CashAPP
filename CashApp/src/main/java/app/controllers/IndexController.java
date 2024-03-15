package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

@Controller    
public class IndexController {


  @GetMapping(path={"/"})
  public String index() {

    return "index"; 
  }

  @GetMapping(path={"/secu"})
  public String secu() {

    return "secu.html"; 
  }
}

