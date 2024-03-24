package ru.goncharov.task3_new.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.goncharov.task3_new.models.Product;
import ru.goncharov.task3_new.services.ProductService;

@Controller
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("products")
    public String getProducts (Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @PostMapping("products")
    public String addProducts (Product p, Model model){
        productService.addProduct(p);
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }




}
