package ru.goncharov.task3_new.services;

import org.springframework.stereotype.Service;
import ru.goncharov.task3_new.models.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
