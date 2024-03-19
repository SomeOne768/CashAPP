package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;

import app.repositories.ProductRepository;
import app.services.MyUserDetailsService;
import app.services.ProductService;
import app.entities.Product;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

import java.nio.file.Path;
import java.nio.file.Files;

@Controller
public class CartController {

    @Autowired
    

}
