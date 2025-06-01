package com.olawale.ProductService.service;

import com.olawale.ProductService.entity.Product;
import com.olawale.ProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllBooks() {
        return productRepository.findAll();
    }
    public Product addBooks(Product product) {
        return productRepository.save(product);
    }

    public Product updateBook(Long id, Product productDetails) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setProductTitle(productDetails.getProductTitle());
                    product.setProductDescription(productDetails.getProductDescription());
                    product.setProductAuthor(productDetails.getProductAuthor());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }



    public void deleteBooks(Long id) {
        productRepository.deleteById(id);

    }


}
