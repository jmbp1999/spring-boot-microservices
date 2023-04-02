package com.jmbp.productservice.service;

import com.jmbp.productservice.dto.ProductRequest;
import com.jmbp.productservice.model.Product;
import com.jmbp.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    //using lombok in the compile time , automatically inject the product repository.


    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();

    }
}
