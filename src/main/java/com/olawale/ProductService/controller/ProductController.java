package com.olawale.ProductService.controller;


import com.olawale.ProductService.entity.Product;
import com.olawale.ProductService.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping({"api/v1/products"})
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController() {
    }

    @GetMapping
    public List<Product> getAllBooks() {
        return this.productService.getAllBooks();
    }

    @PostMapping
    public Product addBooks(@RequestBody Product product) {
        return this.productService.addBooks(product);
    }

    @PutMapping({"/{id}"})
    public Product updateBook(@PathVariable Long id, @RequestBody Product productDetails) {
        return this.productService.updateBook(id, productDetails);
    }

    @DeleteMapping({"/{id}"})
    public void deleteBooks(@PathVariable Long id) {
        this.productService.deleteBooks(id);
    }
}


