package com.olawale.ProductService.service;


import com.olawale.ProductService.entity.Product;
import com.olawale.ProductService.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllBooks() {
        return this.productRepository.findAll();
    }

    public Product addBooks(Product product) {
        return (Product)this.productRepository.save(product);
    }

    public Product updateBook(Long id, Product productDetails) {
        return (Product)this.productRepository.findById(id).map((product) -> {
            product.setProductTitle(productDetails.getProductTitle());
            product.setYear(productDetails.getYear());
            product.setProductPrice(productDetails.getProductPrice());
            return (Product)this.productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("who be you" + id));
    }

    public void deleteBooks(Long id) {
        this.productRepository.deleteById(id);
    }
}
