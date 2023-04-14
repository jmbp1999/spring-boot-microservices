package com.jmbp.productservice.service;

import com.jmbp.productservice.dto.ProductRequest;
import com.jmbp.productservice.dto.ProductResponse;
import com.jmbp.productservice.model.Product;
import com.jmbp.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;




    public Product createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();
        log.info("Product {} is saved",product.getId());
        return productRepository.save(product);
    }

    public List<ProductResponse> getAllProducts() {
        List <Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder().id(product.getId()).name(product.getName()).description(product.getDescription()).build();
    }
}
